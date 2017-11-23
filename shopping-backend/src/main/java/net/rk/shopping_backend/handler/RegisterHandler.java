package net.rk.shopping_backend.handler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import net.rk.shopping_backend.dao.UserDAO;
import net.rk.shopping_backend.dto.Address;
import net.rk.shopping_backend.dto.Cart;
import net.rk.shopping_backend.dto.User;
import net.rk.shopping_backend.model.RegisterModel;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init() {

		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {

		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {

		registerModel.setBilling(billing);
	}

	public String saveAll(RegisterModel model) {

		String transitionValue = "success";

		// fetch the user
		User user = model.getUser();

		if (user.getRole().equals("USER")) {

			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);

		}

		//encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userDAO.addUser(user);
		
		//get the address
		Address billing = model.getBilling();
		
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		//save the address
		userDAO.addAddress(billing);
		
		
		
		return transitionValue;

	}
	
	public String validateUser(User user,MessageContext error){
		
		String transitionValue = "success";
		
		//checking if password is correct or not
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password does not matched to the confirm password")
					.build());
			
			transitionValue="failure";
		}
		
		
		//checkt the uniqueness of email id
		if(userDAO.getByEmail(user.getEmail())!= null){
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email Address is already in use")
					.build());
			
			transitionValue = "failure";
		}
		
		
		return transitionValue;
		
		
	}
	
}
