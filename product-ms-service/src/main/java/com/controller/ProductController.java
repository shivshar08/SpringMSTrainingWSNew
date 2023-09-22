package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.convert.ValueConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.service.ProductService;

@RestController
@RequestMapping("/products")
@RefreshScope
public class ProductController {
	
	  @Value("${product.message}")
	  String message;
	
	  @Autowired
	  private ProductService productService;

	  @PostMapping("/addproduct")
	  Product create(@RequestBody Product product)  {
	    return productService.addProduct(product);
	  }

	  @GetMapping("/getproducts")
	  public List<Product> getProd() {
		System.out.println("Data from product props :: " + message);  
	    return productService.getProducts();
	  }

	  @GetMapping("/getproducts/{plist}")
	  public List<Product> getProductsByIds(@PathVariable List<Long> plist) {
	    return productService.getProductsByIds(plist);
	  }
	  
//	  @GetMapping("/getProducts")
//	  Iterable<Product> getProdsByIds() {
//	    return productService.getProducts();
//	  }

}
