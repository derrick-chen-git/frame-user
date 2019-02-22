package com.frame.user.web.listener;

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
    public void receiveMessage(Message message) throws Exception {
        this.setMaxConsumerCount(4);
       log.info("+++++++++tipic1queue1+++消费消息：{}",new String(message.getBody()));
       //throw new Exception("奥术大师大所大所大多");
    }
}
