package com.frame.dev.web.message.consume;

import com.frame.dev.web.message.channel.input.TestInput;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(TestInput.class)
public class MessageListener {
    @StreamListener(TestInput.TEST1_INPUT)
    public void input(Message<String> message) {
        System.err.println("【*** 消息接收 ***】" + message.getPayload());
    }
}