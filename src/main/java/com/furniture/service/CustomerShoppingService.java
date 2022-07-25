package com.furniture.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.furniture.entity.Cart;
import com.furniture.entity.Customer;
import com.furniture.entity.Furniture;
import com.furniture.entity.FurnitureOrder;
import com.furniture.exception.CustomerShoppingException;
import com.furniture.exception.FurnitureServiceException;
import com.furniture.repository.CustomerRepository;
import com.furniture.repository.IFurnitureRepository;
import com.furniture.repository.IShopingCartRepository;
import com.furniture.repository.OrderRepository;
import com.furniture.service.CustomerShoppingService;
//import com.furniture.serviceimpl.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerShoppingService implements CustomerShoppingServiceInterface {

	static Logger logger = LogManager.getLogger(CustomerShoppingService.class);
	@Autowired
	private IFurnitureRepository furnitureRepo;
	@Autowired
	IShopingCartRepository cartRepo;
	@Autowired
	public OrderRepository orderRepo;
    @Autowired
    public CustomerRepository cup;
	
	@Transactional
	@Override
	public List<Furniture> getAllFurnitures() throws CustomerShoppingException{
		try {
		logger.info("Fetching Furnitures inprogress...");
		List<Furniture> resultFurniture = furnitureRepo.findAll();
		if(resultFurniture!=null) {
		logger.info("Furniture details: " + resultFurniture);
		return resultFurniture;
		}
		else {
			throw new CustomerShoppingException("The Furniture is empty");
		}
		}
		catch(Exception e) {
			throw new CustomerShoppingException("The Furniture is empty");
		}
	}

	
	@Transactional
	@Override
	public Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException {

		try {
			logger.info("Fetching Furnitures inprogress...");
			Furniture result = furnitureRepo.findbyName(furnitureName);
			logger.info("Furniture details: " + result);
				return result; 
		}
		catch (Exception e) {
			throw new CustomerShoppingException("Furniture nor found");
		}
	}
	
	@Override
	public Customer addCustomerDetails(Customer cd) {
	return cup.save(cd);
	}
	@Transactional
 @Override
	public Cart addtoCart(Cart cart) throws CustomerShoppingException {
		if ((cart.getCartId()!= 0)) {

			logger.info("Fetching Cart inprogress...");
			Cart updateUser = cartRepo.save(cart);
			logger.info("Cart details: " + updateUser);
			return updateUser;

		} else {
			throw new CustomerShoppingException("Furniture not added to cart");

		}
//	return cartRepo.save(cart);
	}
	@Transactional
	@Override
	public FurnitureOrder placeOrder(FurnitureOrder order) {
	return orderRepo.save(order);
	}
	
	
	
	
}
