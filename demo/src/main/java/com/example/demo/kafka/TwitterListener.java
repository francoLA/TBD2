package com.example.demo.kafka;

import com.example.demo.repositories.TwittRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.*;

import java.util.List;

@RestController
@Configurable
@RequestMapping(value = "/kafkaProducerB")
public class TwitterListener {

    @Autowired
    private TwitterStream twitterStream;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private TwittRepository twittRepository;


    @Value(value = "${kafka.topicName}")
    private String topicName;

    public void run(List<String> palabras) {
        twitterStream.addListener(new StatusListener()
        {
            public void onStatus(Status status) {
                String tweetJson = TwitterObjectFactory.getRawJSON(status);
                kafkaTemplate.send(topicName,tweetJson);
            }

            @Override
            public void onException(Exception arg0) {
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
            }

            @Override
            public void onStallWarning(StallWarning arg0) {
            }

            @Override
            public void onTrackLimitationNotice(int arg0) {
            }
        });

        String[] listaFinal = palabras.toArray(new String[0]);
        FilterQuery filter = new FilterQuery();
        filter.track(listaFinal);
        filter.language(new String[]{"es"});
        twitterStream.filter(filter);

    }


    public TwitterStream getTwitterStream() {
        return twitterStream;
    }

    public void setTwitterStream(TwitterStream twitterStream) {
        this.twitterStream = twitterStream;
    }
}
