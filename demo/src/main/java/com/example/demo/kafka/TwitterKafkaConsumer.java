package com.example.demo.kafka;

import com.example.demo.models.Twitt;
import com.example.demo.models.User;
import com.example.demo.repositories.TwittRepository;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Service
@EnableScheduling
public class TwitterKafkaConsumer {

    @Autowired
    Consumer<Long, String> consumer;

    @Autowired
    private TwittRepository twittRepository;

    private boolean status;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        this.status = true;
        while(status) {
            ConsumerRecords<Long, String> records = consumer.poll(Duration.of(1, ChronoUnit.SECONDS));
            for (ConsumerRecord<Long, String> record : records) {
                try{
                    System.out.println("\n");
                    System.out.println(record.value());
                    System.out.println("\n");
                    Status s = TwitterObjectFactory.createStatus(record.value());
                    String country = "null",countryCode = "null",region = "null";
                    Double latitude = -1.0,longitude = -1.0;
                    if(s.getPlace() != null) {
                        country = s.getPlace().getCountry();
                        countryCode = s.getPlace().getCountryCode();
                        region = s.getPlace().getName();
                    }
                    if(s.getGeoLocation() != null)
                    {
                        latitude = s.getGeoLocation().getLatitude();
                        longitude = s.getGeoLocation().getLongitude();
                    }
                    User user = new User(s.getUser().getId(),s.getUser().getName(),s.getUser().getScreenName(),s.getUser().getLocation(),s.getUser().getFollowersCount());
                    Twitt twitt = new Twitt(s.getId(),s.getText(),s.getLang(),user,s.getRetweetCount(),s.getFavoriteCount(),country,countryCode,region,latitude,longitude);
                    this.twittRepository.save(twitt);

                }catch(TwitterException name) { System.out.println(name); }

                if (status == false) {
                    break;
                }
            }

        }
    }
    public void stop() { this.status = false; }
}
