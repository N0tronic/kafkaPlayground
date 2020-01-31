package de.play.kafka.config;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "kafka")
@Log4j2
@Data
class TopicConfigurations {
    List<TopicConfiguration> topics;

    @Data
    static class TopicConfiguration {
        String name;
        Integer numPartitions = 3;
        Short replicationFactor = 1;

        NewTopic toNewTopic() {
            log.info("Create Topic {}",name);
            return new NewTopic(this.name, this.numPartitions, this.replicationFactor);
        }
    }
}