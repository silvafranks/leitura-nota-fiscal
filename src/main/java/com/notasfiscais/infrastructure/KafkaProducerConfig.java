package com.notasfiscais.infrastructure;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Value("${topicos.notafiscal.request.topic}")
    private String pagamentoRequestTopic;


    @Bean
    public NewTopic pagamentoRequestTopicBuilder(){
        return TopicBuilder.name(pagamentoRequestTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
