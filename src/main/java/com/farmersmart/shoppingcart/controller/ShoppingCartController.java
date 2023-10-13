package com.farmersmart.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farmersmart.shoppingcart.entity.ShoppingCartEntity;
import com.farmersmart.shoppingcart.service.ShoppingCartService;

@RestController
public class ShoppingCartController {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	@Autowired
	ShoppingCartService service;
	String response;
	@PostMapping("/addToCart")
	public String addToCart(@RequestBody ShoppingCartEntity entity) {
		service.addToCart(entity);
		response = "Added to cart";
		logger.info(response);
		return response;
	}
	@PutMapping("/updateToCart")
	public String updateToCart(@RequestBody ShoppingCartEntity entity) {
		service.updateToCart(entity);
		response = "Updated successfully";
		logger.info(response);
		return response;
	}
	@GetMapping("/getCartDetails")
	public List<ShoppingCartEntity> getCartDetails(){
		return service.getCartDetails();
	}
	@GetMapping("/getCartDetailsById")
	public Optional<ShoppingCartEntity> getCartDetailsById(@RequestParam int id){
		return service.getCartDetailsById(id);
	}
	@DeleteMapping("/deleteFromCart")
	public String deleteFromCart() {
		service.deleteFromCart();
		response = "Deleted successfully";
		logger.info(response);
		return response;
	}
	@DeleteMapping("/deleteFromCartById")
	public String deleteFromCartById(@RequestParam int id) {
		service.deleteFromCartById(id);
		response = "Deleted sucessfully";
		logger.info(response);
		return response;
	}
	
}
