package com.dev.web.rabbitmq.init;

import com.frame.common.rabbitmq.IInitRabbitMqQueue;
import com.frame.common.rabbitmq.RabbitMqUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Data
@Component
@PropertySource("classpath:/rabbitmq.properties")
public class TopicTest1RabbitmqInit implements IInitRabbitMqQueue {

    @Autowired
    private RabbitMqUtils rabbitMqUtils;

    @Value("${rabbitmq.topic.test1.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.topic.test1.exchange.type}")
    private String exchangeType;
    @Value("${rabbitmq.topic.test1.queue.name}")
    private String queueName;
    @Value("${rabbitmq.topic.test1.route.key}")
    private String routingKey;


    @Override
    @PostConstruct
    public void initRabbitMqQueue() {
        this.rabbitMqUtils.initRabbitMqQueue(exchangeName,queueName,exchangeType,routingKey,false,false);
    }
}
