package com.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.MessageConfig;
import com.model.Order;
import com.model.OrderStatus;

@RestController
@RequestMapping("/order")
public class OrderPublisher {
   @Autowired
	private RabbitTemplate template;
   @PostMapping("/{restaurantName}")
   public String placeOder(@RequestBody Order order,@PathVariable String restaurantName) {
	   order.setOrderId(UUID.randomUUID().toString());
	   OrderStatus status= new OrderStatus(order,"Progress...!", "Processing your order to the restaurant....!"+ restaurantName);
	   template.convertAndSend(MessageConfig.EXCHANGE,MessageConfig.ROUTING_KEY,status);
	   return "SUCCESS";
	   
   }
}
