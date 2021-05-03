package com.kafka.sample.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Producer {
  @Value("${kafka-properties.topic-name}")
  private String TOPIC;

  private final KafkaTemplate<String, User> kafkaTemplate;
  private final KafkaTemplate<String, String> test;

  public void sendMessage(User user) {
    ProducerRecord<String, User> producerRecord = new ProducerRecord<>(TOPIC, user);

    log.info(String.format("#### -> Producing message -> %s", user));
    this.kafkaTemplate.send(producerRecord);
  }
}
