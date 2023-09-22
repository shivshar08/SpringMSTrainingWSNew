package com.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.config.MessageConfig;
import com.model.OrderStatus;

@Component
public class Restaurant {
	@RabbitListener(queues = MessageConfig.QUEUE)
	public void consumeMessage(OrderStatus orderStatus) {
		System.out.println("Message from Queue.. " + orderStatus);
	}

}
