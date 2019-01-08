/*
package com.frame.dev.web.message.consume;

import com.frame.dev.web.message.channel.input.TestInput;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(TestInput.class)
public class MessageListener {
    @StreamListener(TestInput.TEST1_INPUT)
    public void input1(Message<String> message,@Header(AmqpHeaders.CHANNEL) Channel channel,
                       @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag) throws Exception {
        System.err.println("【*** 消息接收 ***】" + message.getPayload());
        try {
            //channel.basicNack(deliveryTag,false,false);//手动确认
            channel.basicReject(deliveryTag,false);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

    }
 @StreamListener(TestInput.TEST1_INPUT_DLQ)
    public void input1Dlq(Message<String> message,@Header(AmqpHeaders.CHANNEL) Channel channel,
                       @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag) throws Exception {
        System.err.println("【*** 消息接收 test1私信队列 处理 ***】" + message.getPayload());
        try {
            channel.basicAck(deliveryTag,false);//手动确认
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

    }

    @StreamListener(TestInput.TEST2_INPUT)
    public void input2(Message<String> message) {
        System.err.println("【*** 消息接收222 ***】" + message.getPayload());
    }
}
*/
