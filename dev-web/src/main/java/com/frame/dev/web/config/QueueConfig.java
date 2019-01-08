package com.frame.dev.web.config;

import com.frame.dev.web.rabbitmq.listener.TopicQueue1Listener;
import com.frame.dev.web.rabbitmq.listener.TopicQueue2Listener;
import com.frame.starter.rabbitmq.utils.MyQueue;
import com.frame.starter.rabbitmq.utils.RabbitMqUtils;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by lemonade on 2019/1/7.
 */
@Configuration
public class QueueConfig {
    @Autowired
    private RabbitMqUtils rabbitMqUtils;
    @Bean
    public Queue topicTestQueue1(){
        MyQueue myQueue = MyQueue.builder().exchangeName("topic_test_exchange")
                .queueName("topic_test_queue1").autoDelete(false).durable(false).routingKey("key1")
                .exchangeType(ExchangeTypes.TOPIC).build();
       return this.rabbitMqUtils.init(myQueue);
    }
    @Bean
    public Queue topicTestQueue2(){
        MyQueue myQueue = MyQueue.builder().exchangeName("topic_test_exchange")
                .queueName("topic_test_queue2").autoDelete(false).durable(false).routingKey("key2")
                .exchangeType(ExchangeTypes.TOPIC).build();
        return this.rabbitMqUtils.init(myQueue);
    }
    @Bean
    public Queue fanoutTestQueue1(){
        MyQueue myQueue = MyQueue.builder().exchangeName("fanout_test_exchange")
                .queueName("fanout_test_queue1").autoDelete(false).durable(false)
                .exchangeType(ExchangeTypes.FANOUT).build();
        return this.rabbitMqUtils.init(myQueue);
    }
    @Bean
    public Queue fanoutTestQueue2(){
        MyQueue myQueue = MyQueue.builder().exchangeName("fanout_test_exchange")
                .queueName("fanout_test_queue2").autoDelete(false).durable(false)
                .exchangeType(ExchangeTypes.FANOUT).build();
            return this.rabbitMqUtils.init(myQueue);
    }
    @Bean
    public SimpleMessageListenerContainer TopicQueue1ListenerContainer(ConnectionFactory connectionFactory, TopicQueue1Listener topicQueue1Listener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(topicTestQueue1());
        container.setExposeListenerChannel(true);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(topicQueue1Listener);
        return container;
    }

    @Bean
    public SimpleMessageListenerContainer TopicQueue2ListenerContainer(ConnectionFactory connectionFactory, TopicQueue2Listener topicQueue2Listener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(topicTestQueue2());
        container.setExposeListenerChannel(true);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(topicQueue2Listener);
        return container;
    }
}
