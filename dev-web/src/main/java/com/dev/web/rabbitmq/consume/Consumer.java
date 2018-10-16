package com.dev.web.rabbitmq.consume;

import com.dev.web.entity.User;
import com.frame.common.utils.JacksonUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues="topic_test_queue1")
    public void processT1(String msg) {
        try {
            System.out.println("topic1:"+ JacksonUtils.json2pojo(msg, User.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RabbitListener(queues="topic_test_queue2")
    public void processT2(String msg) {
        try {
            System.out.println("topic2:"+ JacksonUtils.json2pojo(msg, User.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
