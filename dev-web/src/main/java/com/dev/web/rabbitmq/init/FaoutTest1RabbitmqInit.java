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
public class FaoutTest1RabbitmqInit implements IInitRabbitMqQueue {

    @Autowired
    private RabbitMqUtils rabbitMqUtils;

    @Value("${rabbitmq.fanout.test1.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.fanout.test1.exchange.type}")
    private String exchangeType;
    @Value("${rabbitmq.fanout.test1.queue.name}")
    private String queueName;



    @Override
    @PostConstruct
    public void initRabbitMqQueue() {
        this.rabbitMqUtils.initRabbitMqQueue(exchangeName,queueName,exchangeType,null,false,false);
    }
}
