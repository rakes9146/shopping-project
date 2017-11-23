package net.rk.shopping_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.rk.shopping_backend.dao.UserDAO;
import net.rk.shopping_backend.dto.Address;
import net.rk.shopping_backend.dto.Cart;
import net.rk.shopping_backend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user;
	private Cart cart;
	private Address address;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.rk.shopping_backend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

	}

	/*
	@Test
	public void testAdd() {

		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("ht@gmail.com");
		user.setContactNumber("1234565");
		user.setRole("USER");
		user.setPassword("12345");

		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krrish Nager");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("40001");
		address.setBilling(true);

		// link the user with the address user id
		address.setUserId(user.getId());

		// add the address
		assertEquals("Failed to add address! ", true, userDAO.addAddress(address));

		if (user.getRole().equals("USER")) {

			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);

			// add the cart
			assertEquals("Failed to load cart!", true, userDAO.addCart(cart));

			// add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya  Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400101");
			address.setShipping(true);

			// link it with user
			address.setUserId(user.getId());
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));

		}
	}
*/
	
	/*
	@Test
	public void testAdd() {

		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("ht@gmail.com");
		user.setContactNumber("1234565");
		user.setRole("USER");
		user.setPassword("12345");

		if (user.getRole().equals("USER")) {

			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);
            user.setCart(cart); 

		}

			assertEquals("Failed to add user!", true, userDAO.addUser(user));
	
	}
	*/

/*
  @Test	
  public void testUpdateCart(){
	  
	  //fetch user detail by its email
	  user = userDAO.getByEmail("ht@gmail.com");
	  
	  //get the cart of the user
	  cart = user.getCart();
	  
	  cart.setGrandTotal(55.55);
	  cart.setCartLines(2);
	  
	  assertEquals("Failed to update the cart!",true,userDAO.updateCart(cart));
	  
  }
  */
/*
	@Test
	public void testAddAddress(){
		
		//we need to add an user
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("ht@gmail.com");
		user.setContactNumber("1234565");
		user.setRole("USER");
		user.setPassword("12345");

		assertEquals("Failed to add user!", true, userDAO.addUser(user));

		
        //we are going to add address for billing
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krrish Nager");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("40001");
		address.setBilling(true);
		
		//attatch use to the address
		address.setUser(user);
		assertEquals("Failed to load the address",true,userDAO.addAddress(address));
		
		
		//we are going to address for shipping
		// add a shipping address for this user
					address = new Address();
					address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya  Nagar");
					address.setAddressLineTwo("Near Kudrat Store");
					address.setCity("Mumbai");
					address.setState("Maharashtra");
					address.setCountry("India");
					address.setPostalCode("400101");
					address.setShipping(true);
					
		//attached the user to address
		address.setUser(user);
		assertEquals("Failed to load shipping address",true,userDAO.addAddress(address));
		
		
	}
	
	*/
	
	/*
	@Test
	public void testAddAddress(){
		
		user = userDAO.getByEmail("ht@gmail.com");
		
		
		address = new Address();
		address.setAddressLineOne("301/B Shanit Society, Kishan Kanhaiya  Nagar");
		address.setAddressLineTwo("Durga Mata Mandir");
		address.setCity("Nagpur");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400201");
		address.setShipping(true);
		
		//attached user to address
		address.setUser(user);
		
		assertEquals("Failed to addshipping address!",true,userDAO.addAddress(address));
		
	}
	*/
	/*
	@Test
	public void testGetAddress(){
		
		user = userDAO.getByEmail("ht@gmail.com");
		
		assertEquals("Failed to fethc the list of address",2,userDAO.listShippingAddresses(user).size());
		
		assertEquals("Failed to fethc the list of billing  address","Mumbai",userDAO.getBillingAddress(user).getCity());
		
	}
	*/
}