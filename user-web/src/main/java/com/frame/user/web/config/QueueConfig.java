package com.frame.user.web.config;

import com.frame.user.web.listener.TopicQueue1Listener;
import com.frame.user.web.listener.TopocQueue1DlxeListener;
import com.frame.starter.rabbitmq.constans.MQConstants;
import com.frame.starter.rabbitmq.utils.MyQueue;
import com.frame.starter.rabbitmq.utils.QueueArgument;
import com.frame.starter.rabbitmq.utils.RabbitMqUtils;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Queue;
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

    /**
     * 死信队列
     * @return
     */
    @Bean
    public Queue dlxQueue(){
        MyQueue myQueue = MyQueue.builder().exchangeName(MQConstants.DLX_EXCHANGE)
                .queueName(MQConstants.DLX_QUEUE).autoDelete(false).durable(false).routingKey(MQConstants.DLX_ROUTING_KEY)
                .exchangeType(ExchangeTypes.TOPIC).build();
        return this.rabbitMqUtils.init(myQueue);
    }
    /**
     * topic类型测试队列1
     * @return
     */
    @Bean
    public Queue topicTestQueue1(){
        QueueArgument agrs = QueueArgument.builder().dlxExchangeName(MQConstants.DLX_EXCHANGE)
                .dlxRoutingkey(MQConstants.DLX_ROUTING_KEY).build();
        MyQueue myQueue = MyQueue.builder().exchangeName("topic_test_exchange")
                .queueName("topic_test_queue1").autoDelete(false).durable(true).routingKey("key1")
                .exchangeType(ExchangeTypes.TOPIC).queueArgument(agrs).build();
       return this.rabbitMqUtils.init(myQueue);
    }
    /**
     * topic类型测试队列2
     * @return
     */
    @Bean
    public Queue topicTestQueue2(){
        QueueArgument agrs = QueueArgument.builder().dlxExchangeName(MQConstants.DLX_EXCHANGE)
                .dlxRoutingkey(MQConstants.DLX_ROUTING_KEY).build();
        MyQueue myQueue = MyQueue.builder().exchangeName("topic_test_exchange")
                .queueName("topic_test_queue2").autoDelete(false).durable(true).routingKey("key2")
                .exchangeType(ExchangeTypes.TOPIC).queueArgument(agrs).build();
        return this.rabbitMqUtils.init(myQueue);
    }
    @Bean
    public Queue fanoutTestQueue1(){
        MyQueue myQueue = MyQueue.builder().exchangeName("fanout_test_exchange")
                .queueName("fanout_test_queue1").autoDelete(false).durable(true)
                .exchangeType(ExchangeTypes.FANOUT).build();
        return this.rabbitMqUtils.init(myQueue);
    }
    @Bean
    public Queue fanoutTestQueue2(){
        MyQueue myQueue = MyQueue.builder().exchangeName("fanout_test_exchange")
                .queueName("fanout_test_queue2").autoDelete(false).durable(true)
                .exchangeType(ExchangeTypes.FANOUT).build();
        return this.rabbitMqUtils.init(myQueue);
    }
    @Bean
    public SimpleMessageListenerContainer TopicQueue1ListenerContainer(TopicQueue1Listener topicQueue1Listener) {
        return rabbitMqUtils.initListenerContainer(topicTestQueue1(),topicQueue1Listener,AcknowledgeMode.MANUAL,100);
    }

    @Bean
    public SimpleMessageListenerContainer deadLetterListenerContainer(TopocQueue1DlxeListener topocQueue1DlxeListener) {
        return rabbitMqUtils.initListenerContainer(dlxQueue(),topocQueue1DlxeListener,AcknowledgeMode.MANUAL,100);

    }
}
