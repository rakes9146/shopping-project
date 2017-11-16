package net.rk.shopping_backend.dao;

import java.util.List;

import net.rk.shopping_backend.dto.Address;
import net.rk.shopping_backend.dto.Cart;
import net.rk.shopping_backend.dto.User;

public interface UserDAO {

	//add an user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	
	//add to cart
	boolean updateCart(Cart cart);
	
}
