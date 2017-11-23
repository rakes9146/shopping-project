package net.rk.shopping_backend.dao;

import java.util.List;

import net.rk.shopping_backend.dto.Cart;
import net.rk.shopping_backend.dto.CartLine;
import net.rk.shopping_backend.dto.OrderDetail;

public interface CartLineDAO {

	//common methods
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	//other business related methods
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId,int Product);
	boolean updateCart(Cart cart);
	public boolean remove(CartLine cartLine);
	public boolean addOrderDetasil(OrderDetail orderDetail);
	
	
}
