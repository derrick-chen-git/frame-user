package com.frame.dev.web.rabbitmq.consume;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues="topic_test_queue1")
    public void process(Message message, Channel channel) throws IOException {

        //成功处理
          /* channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
                       log.info("receive: " + new String(message.getBody()));*/
     /*  channel.basicNack();
                    }*/
    }


    @RabbitListener(queues="topic_test_queue2")
    public void processT2(Message message, Channel channel) throws IOException {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            log.info("receive: " + new String(message.getBody()));

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
