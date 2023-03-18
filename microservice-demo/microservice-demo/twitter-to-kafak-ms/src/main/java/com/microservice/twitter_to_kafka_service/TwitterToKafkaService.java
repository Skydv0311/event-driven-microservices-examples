package com.microservice.twitter_to_kafka_service;

import com.microservice.twitter_to_kafka_service.config.TwitterToKafkaServiceConfigData;
import com.microservice.twitter_to_kafka_service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.PrimitiveIterator;

@SpringBootApplication
public class TwitterToKafkaService implements CommandLineRunner {

    private static final Logger LOG= LoggerFactory.getLogger(TwitterToKafkaService.class);


    private final TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;
    private final StreamRunner streamRunner;

    public TwitterToKafkaService(TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData, StreamRunner streamRunner) {
        this.twitterToKafkaServiceConfigData = twitterToKafkaServiceConfigData;
        this.streamRunner=streamRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaService.class);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("App starts...");
        LOG.info(Arrays.toString(twitterToKafkaServiceConfigData.getTwitterKeywords().toArray(new String[] {})));
        LOG.info(twitterToKafkaServiceConfigData.getWelcomeMessage());
        streamRunner.start();

    }
}
