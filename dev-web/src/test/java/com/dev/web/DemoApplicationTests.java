package com.dev.web;

import com.frame.common.rabbitmq.RabbitMqUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private RabbitMqUtils rabbitMqUtils;

	@Test
	public void contextLoads() {
	}

	@Test
	public void sendMsg(){
		rabbitMqUtils.convertAndSend("topic_test_exchange","key1","topic消息+++++++++++++++++++");
	}
	@Test
	public void sendFMsg(){
		rabbitMqUtils.convertAndSend("fanout_test_exchange",null,"fanout消息+++++++++++++++++++");
	}
}
