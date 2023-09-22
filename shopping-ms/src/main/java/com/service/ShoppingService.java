package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dao.ShoppingDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.CartEntity;
import com.model.CartRequest;
import com.model.CartResponse;
import com.model.Product;

@Service
public class ShoppingService {
	@Autowired
	@Qualifier("webClient")
	private WebClient.Builder builder;
	@Autowired
	private ShoppingDao repo;
	
	public CartResponse processAndRequest(Long userId,List<CartRequest> shoppingCartRequestList) {
		//calling product api
		ObjectMapper mapper = new ObjectMapper();
		String productServiceURL = "http://localhost:8070/products/getproducts/" + shoppingCartRequestList.stream()
		.map(e -> String.valueOf(e.getProductId())).collect(Collectors.joining(","));
		
		System.out.println("productServiceURL");
		System.out.println(productServiceURL);
		
		List<Product> productServiceList = builder.build().get().uri(productServiceURL)
				.retrieve()
				.bodyToFlux(Product.class)
				.collectList()
				.block();
		
		
		System.out.println("productServiceList");
		System.out.println(productServiceList);
		
		final Double[] totalCost= {0.0};
		

		productServiceList.forEach(psl -> {
			shoppingCartRequestList.forEach(scr->{
				if(psl.getProductID()==scr.getProductId()) {
					psl.setQuantity(scr.getQuantity());
					totalCost[0]=totalCost[0]+psl.getAmount()*scr.getQuantity();
					}
			});
		});
		
		System.out.println("After total qty ");
		System.out.println("productServiceURL");
		System.out.println(productServiceURL);
		System.out.println("productServiceList");
		System.out.println(productServiceList);
		// create cartEntity
		CartEntity cartEntity=null;
		try {
			cartEntity=CartEntity.builder()
					.userId(userId)
					.cartId((long)(Math.random()*Math.pow(10, 10)))
					.totalItems(productServiceList.size())
					.totalCosts(totalCost[0])
					.products(mapper.writeValueAsString(productServiceList))
					.build();
		}

		catch (Exception e) {}
		cartEntity=repo.save(cartEntity);
		
		CartResponse response = CartResponse.builder()
				.cartId(cartEntity.getCartId())
				.userId(cartEntity.getUserId())
				.totalItems(cartEntity.getTotalItems())
				.totalCosts(cartEntity.getTotalCosts())
				.products(productServiceList)
				.build();
				
		return response;
	}
	

}
