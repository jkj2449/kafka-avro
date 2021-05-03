package com.kafka.sample.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "kafka-properties")
public class KafkaProperties {
  private String bootstrapServer;
  private Integer partitions;
  private short replicationFactor;
  private String topicName;
  private String groupId;
}
