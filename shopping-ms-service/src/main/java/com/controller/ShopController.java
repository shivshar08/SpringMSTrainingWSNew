package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.CartRequest;
import com.model.CartResponse;
import com.service.ShoppingService;

@RestController
@RequestMapping("shoppingcart")
public class ShopController {
	@Autowired
	private ShoppingService shoppingService;

	@PostMapping("/{userid}/products")
	public ResponseEntity addProduct(@PathVariable Long userid, @RequestBody List<CartRequest> reqList) {
		CartResponse resp = shoppingService.processAndRequest(userid, reqList);
		return new ResponseEntity(resp,HttpStatus.CREATED);
		
	}
	
}
