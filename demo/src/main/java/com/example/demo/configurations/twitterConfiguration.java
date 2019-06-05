package com.example.demo.configurations;

import com.example.demo.kafka.TwitterListener;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnClass({TwitterStreamFactory.class,TwitterStream.class, TwitterListener.class})
public class twitterConfiguration {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    public static final String CONSUMER_KEY = "1G03SK33DWHRBNUdKeafcyJwz";
    public static final String CONSUMER_SECRET = "6nGvtnsiTvg55b0LhrDsrgLHdWUhXBEu1mcezwzRwsoF8emr0K";
    public static final String ACCESS_TOKEN = "1132543070585741312-RceaOmMLdhv2M8HYSUwd8KeiQYd7tY";
    public static final String TOKEN_SECRET = "py9fpFnUuwSPswWRzrZ24MrHz5f4Ltozx71Mr5hSWhbfZ";

    @Bean
    @ConditionalOnMissingBean
    public TwitterStreamFactory twitterStreamFactory() {
        ConfigurationBuilder configurationBuilder=new ConfigurationBuilder();
        configurationBuilder
                .setDebugEnabled(false)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TOKEN_SECRET)
                .setJSONStoreEnabled(true);
        return new TwitterStreamFactory(configurationBuilder.build());
    }

    @Bean
    @ConditionalOnMissingBean
    public TwitterStream twitterStream(TwitterStreamFactory twitterStreamFactory) {
        return twitterStreamFactory.getInstance();
    }
    @Bean
    @ConditionalOnMissingBean
    public TwitterListener twitterListener() {
        return new TwitterListener();
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
