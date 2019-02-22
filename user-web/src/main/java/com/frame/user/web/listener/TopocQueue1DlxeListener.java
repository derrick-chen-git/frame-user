package com.frame.user.web.listener;

import com.frame.starter.rabbitmq.listener.DLXAbstractMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopocQueue1DlxeListener extends DLXAbstractMessageListener {

    @Override
    public void receiveMessage(Message message) {
        log.error("++++++死信队列消费,msg:{}",new String(message.getBody()));
    }
}