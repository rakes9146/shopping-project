package net.rk.shopping_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.rk.shopping_backend.dao.CartLineDAO;
import net.rk.shopping_backend.dao.ProductDAO;
import net.rk.shopping_backend.dao.UserDAO;
import net.rk.shopping_backend.dto.Cart;
import net.rk.shopping_backend.dto.CartLine;
import net.rk.shopping_backend.dto.Product;
import net.rk.shopping_backend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.rk.shopping_backend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		
		
	}
	
	@Test
	public void testAddNewCartLine(){
		
		//1. Get the user
		user = userDAO.getByEmail("r@gmail.com");
	
		//2. Fetch the Cart
		cart = user.getCart();
		
		//3. get theProduct
		product = productDAO.get(1);
		
		//4. New Cart Line
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount()+1);
		
		cartLine.setTotal(cartLine.getProductCount()*product.getUnitPrice());
		
		cartLine.setAvailable(true); 
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("Failded to add the cart Line",true, cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		
		assertEquals("Failded to update the cart",true, cartLineDAO.updateCart(cart));
		
		
		
	}
	
}
