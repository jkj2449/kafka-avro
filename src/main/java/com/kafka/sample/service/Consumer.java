package com.kafka.sample.service;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.apache.avro.specific.SpecificData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

  @KafkaListener(topics = "users", groupId = "test")
  public void consume(ConsumerRecord<String, User> record) {
    User user = record.value();

    log.info("Name" + user.getName());
    log.info(String.format("#### -> Consumed message -> %s", record.value()));
  }
}
