package com.java.springboot;

import com.java.springboot.model.Wikimedia;
import com.java.springboot.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDataBaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDataBaseConsumer.class);

    private final WikimediaRepository wikimediaRepository;

    public KafkaDataBaseConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){
        LOGGER.info(String.format("Message received -> %s", eventMessage));
        Wikimedia wikimedia = new Wikimedia();

        wikimedia.setWikimedia(eventMessage);

        wikimediaRepository.save(wikimedia);
    }
}
