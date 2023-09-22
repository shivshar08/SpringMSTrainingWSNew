package com.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartRequest {
	private Long productId;
	private Integer quantity;
	

}
