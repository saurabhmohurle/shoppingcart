package com.farmersmart.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmersmart.shoppingcart.entity.ShoppingCartEntity;
import com.farmersmart.shoppingcart.entity.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartService.class);
	@Autowired
	ShoppingCartRepository repository;
	String  response;

	public String addToCart(ShoppingCartEntity entity) {
		// TODO Auto-generated method stub
		System.out.println(entity.toString());
		logger.info(entity.toString());
		repository.save(entity);
		response = "Added successfully";
		logger.info(response);
		return response;
	}

	public String updateToCart(ShoppingCartEntity entity) {
		// TODO Auto-generated method stub
		System.out.println(entity.toString());
		logger.info(entity.toString());
		repository.save(entity);
		response = "Updated successfully";
		logger.info(response);
		return response;
	}

	public List<ShoppingCartEntity> getCartDetails() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Optional<ShoppingCartEntity> getCartDetailsById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	public String deleteFromCart() {
		// TODO Auto-generated method stub
		repository.deleteAll();
		response = "Deleted successfully";
		return response;
	}

	public String deleteFromCartById(int id) {
		// TODO Auto-generated method stub
		try {
			repository.deleteById(id);
			response = "Deleted successfully";
			logger.info(response);
		} catch (Exception e) {
			// TODO: handle exception
			response = "Invalid ID: "+id;
			logger.info(response);
		}
		return response;
	}
	
}
