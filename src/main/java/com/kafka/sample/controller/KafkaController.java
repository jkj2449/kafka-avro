package com.kafka.sample.controller;

import com.kafka.sample.service.Producer;
import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

  private final Producer producer;

  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(@RequestBody User user) {
    this.producer.sendMessage(user);
  }
}