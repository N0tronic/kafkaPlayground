package de.play.kafka;

import de.play.kafka.vo.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class Consumer {
    @KafkaListener(topics = "#{'${topic}'}")
    public void consume(@Payload Person person) {
        log.info("Consumed value -> {}", person);
    }
}
