package com.dev.web.rabbitmq.consume;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues="topic_test_queue1")
    public void processT1(String msg) {
        System.out.println("topic1:"+msg);
    }
    @RabbitListener(queues="topic_test_queue2")
    public void processT2(String msg) {
        System.out.println("topic2:"+msg);
    }
    @RabbitListener(queues="fanout_test_queue1")
    public void processF1(String msg) {
        System.out.println("fanout1:"+msg);
    }
    @RabbitListener(queues="fanout_test_queue2")
    public void processF2(String msg) {
        System.out.println("fanout2:"+msg);
    }
}
