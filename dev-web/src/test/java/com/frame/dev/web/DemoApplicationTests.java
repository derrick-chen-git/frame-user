package com.frame.dev.web;

import com.frame.starter.rabbitmq.sender.RabbitMqSender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableBinding(TestOutput.class)
public class DemoApplicationTests {
	@Autowired
	RabbitMqSender rabbitSender;
/*	@Autowired
	private RabbitMqUtils rabbitMqUtils;*/
	//@Autowired
	//private TestOutput testOutput;

	/*@Test
	public void test1output(){
		this.testOutput.testOutput().send(MessageBuilder.withPayload("derrick -----chen ********").build());
	}*/
	@Test
	public void contextLoads() {
	}

	/*@Test
	public void sendMsg(){
		User user = new User();
		user.setId(1L);
		user.setName("derrick");
		try {
			//topic1MessageSender.send(user);
			rabbitMqUtils.send("topic_test_exchange","key1", JacksonUtils.obj2json(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	@Test
	public void sendFMsg(){
//		rabbitMqUtils.convertAndSend("fanout_test_exchange",null,"fanout消息+++++++++++++++++++");
	}
	/*@Test
	public void sendFMsgadasda(){
		rabbitMqConfig.seng();
	}*/
	@Test
	public void transSend(){
		rabbitSender.sendMessage("topic_test_exchange","key1","++++测试topickey1+++",false);
	}

}
