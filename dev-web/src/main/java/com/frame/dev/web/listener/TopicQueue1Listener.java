package com.frame.dev.web.listener;

import com.frame.starter.rabbitmq.listener.AbstractMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

/**
 * Created by lemonade on 2019/1/7.
 */
@Component
@Slf4j
public class TopicQueue1Listener extends AbstractMessageListener {
    @Override
    public void receiveMessage(Message message) {
       log.info("TopicQueue1Listener"+ new String(message.getBody()));
    }
}
