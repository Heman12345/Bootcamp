package com.furniture.service;

import java.util.List;

import com.furniture.entity.Cart;
import com.furniture.entity.Customer;
import com.furniture.entity.Furniture;
import com.furniture.entity.FurnitureOrder;
import com.furniture.exception.CustomerShoppingException;

public interface CustomerShoppingServiceInterface {

	List<Furniture> getAllFurnitures() throws CustomerShoppingException;

	Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException;
	public Customer addCustomerDetails(Customer cd);

	public Cart addtoCart(Cart cart) throws CustomerShoppingException ;

	public FurnitureOrder placeOrder(FurnitureOrder order) ;
}

