package de.play.kafka;

import de.play.kafka.vo.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class Producer {

    @Value("${topic}")
    private String topic;

    private final KafkaTemplate<String, Person> kafkaTemplate;

    public void sendMessage(@Payload Person person) {
        log.info("Producing message -> {}", person);
        this.kafkaTemplate.send(topic, person);
    }
}
