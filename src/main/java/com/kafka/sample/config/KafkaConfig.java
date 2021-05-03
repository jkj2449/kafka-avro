package com.kafka.sample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
  //private final KafkaProperties kafkaProperties;
  @Value("${kafka-properties.topic-name}")
  private String topicName;
  @Value("${kafka-properties.partitions-num}")
  private int partitions;
  @Value("${kafka-properties.replication-factor}")
  private short replicationFactor;

  @Bean
  public NewTopic moviesTopic() {
    return new NewTopic(topicName, partitions, replicationFactor);
  }

//  @Bean
//  public ConcurrentKafkaListenerContainerFactory<String, User> kafkaListener() {
//    ConcurrentKafkaListenerContainerFactory<String, User> kafkaListener = new ConcurrentKafkaListenerContainerFactory<>();
//    kafkaListener.setConsumerFactory(consumerFactory());
//    return kafkaListener;
//  }
//
//  @Bean
//  public ConsumerFactory<String, User> consumerFactory() {
//    return new DefaultKafkaConsumerFactory<>(consumerConfigurations());
//  }
//
//  @Bean
//  public Map<String, Object> consumerConfigurations() {
//    return Map.of(
//        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServer(),
//        ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getGroupId(),
//        ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG, Lists.newArrayList(MonitoringConsumerInterceptor.class),
//        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest",
//        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
//        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class
//    );
//  }
//
//  @Bean
//  public KafkaAvroDeserializer kafkaAvroDeserializer() {
//    KafkaAvroDeserializer kafkaAvroDeserializer = new KafkaAvroDeserializer();
//    kafkaAvroDeserializer.configure(
//        Map.of(
//            KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true,
//            "schema.registry.url", "http://localhost:8081"
//    ), true);
//
//    return kafkaAvroDeserializer;
//  }
//
//  @Bean
//  public KafkaTemplate<String, User> kafkaTemplate() {
//    return new KafkaTemplate<>(producerFactory());
//  }
//
//  @Bean
//  public ProducerFactory<String, User> producerFactory() {
//    return new DefaultKafkaProducerFactory<>(producerConfigurations());
//  }
//
//  @Bean
//  public Map<String, Object> producerConfigurations() {
//    return Map.of(
//        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServer(),
//        ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, Lists.newArrayList(MonitoringProducerInterceptor.class),
//        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
//        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class
//    );
//  }
//
//  @Bean
//  public KafkaAvroSerializer kafkaAvroSerializer() {
//    KafkaAvroSerializer kafkaAvroSerializer = new KafkaAvroSerializer();
//    kafkaAvroSerializer.configure(
//        Map.of(
//            KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true,
//            "schema.registry.url", "http://localhost:8081"
//        ), true);
//
//    return kafkaAvroSerializer;
//  }
 }
