package de.play.kafka.rest;

import de.play.kafka.Producer;
import de.play.kafka.vo.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class PersonController {

    private final Producer producer;

    @PostMapping(value = "/publishPerson",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> sendMessageToKafkaTopic(@RequestBody Person person) {
        producer.sendMessage(person);
        return ResponseEntity.of(Optional.of(person));
    }

}
