package net.rk.shoppingfrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.rk.shopping_backend.dao.UserDAO;
import net.rk.shopping_backend.dto.User;
import net.rk.shopping_backend.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserDAO userDAO;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {

		if (session.getAttribute("userModel") == null) {

			// Add the UserModel
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userDAO.getByEmail(authentication.getName());
			if (user != null) {
				// create a new user model to pass the user detail object
				UserModel userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
		               
				  if(userModel.getRole().equals("USER")){
					  //set the cart
					  userModel.setCart(user.getCart());
					  
				  }
				  //set The user Model in session
				  session.setAttribute("userModel", userModel);
				  return userModel;
			}

		}

		return (UserModel) session.getAttribute("userModel");
	}
}
