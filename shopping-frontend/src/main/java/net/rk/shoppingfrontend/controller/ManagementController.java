package net.rk.shoppingfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rk.shoppingfrontend.util.FileUploadUtility;
import com.rk.shoppingfrontend.vaidator.ProductValidator;

import net.rk.shopping_backend.dao.CategoryDAO;
import net.rk.shopping_backend.dao.ProductDAO;
import net.rk.shopping_backend.dto.Category;
import net.rk.shopping_backend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		Product nProduct = new Product();

		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {

				mv.addObject("message", "Product Submtted Successfully");
			}else if(operation.equals("category")){
				
				mv.addObject("message", "Category Submtted Successfully");
			}

		}

		return mv;

	}

	// handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result,
			Model model, HttpServletRequest request) {

		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, result);
		} else {
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, result);
			}
		}
		// check if thereare any errors
		if (result.hasErrors()) {

			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation Failed for produt");

			return "page";
		}

		logger.info(mProduct.toString());
		// create new product DAO
		if (mProduct.getId() == 0) {
			// create the product if id is0
			productDAO.add(mProduct);
		} else {
			// update the product if id not equals to 0
			productDAO.update(mProduct);
		}

		if (!mProduct.getFile().getOriginalFilename().equals("")) {

			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/products?operation=product";
	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		// is going to fetch the product from the database
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		// activatiing and deactivation based ont he value of active field
		product.setActive(!product.isActive());
		// updating the product
		productDAO.update(product);

		return (isActive) ? "You have successfully Deactivated the product with id " + product.getId()
				: "You have successfully Activated the product with id " + product.getId();

	}

	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		// fetch the product from the databse

		Product nProduct = productDAO.get(id);
		// set the product fetch frm the datavase
		mv.addObject("product", nProduct);

		return mv;

	}

	//to handle the category submission
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)
	{
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
		
	}
	
	@ModelAttribute("category")
	public Category getCategory() {

		return new Category();
	}

	// returning categories
	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.list();

	}

}
