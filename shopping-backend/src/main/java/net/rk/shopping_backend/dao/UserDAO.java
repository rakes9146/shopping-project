package net.rk.shopping_backend.dao;

import java.util.List;

import net.rk.shopping_backend.dto.Address;
import net.rk.shopping_backend.dto.Cart;
import net.rk.shopping_backend.dto.User;

public interface UserDAO {

	//add an user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	User get(int id);
	
	//add an address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	Address getBillingAddress(int userId);
	boolean updateAddress(Address address);
	
	List<Address> listShippingAddresses(int userId);
	
	
	//add to cart
	
	
}
