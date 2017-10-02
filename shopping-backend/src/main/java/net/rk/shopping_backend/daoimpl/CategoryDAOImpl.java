package net.rk.shopping_backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.rk.shopping_backend.dao.CategoryDAO;
import net.rk.shopping_backend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		// adding first Category
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is Telelvision");
		category.setImageURL("dsfds");
		categories.add(category);

		// add Second Category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is Telelvision");
		category.setImageURL("dsfds");
		categories.add(category);

		// add Third Category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is Telelvision");
		category.setImageURL("dsfds");

		category = new Category();
        category.setId(4);
        category.setName("Refrigerator");
        category.setDescription("This is Telelvision");
        category.setImageURL("dsfds");
    	categories.add(category);

    	category = new Category();
        category.setId(5);
        category.setName("Camera");
        category.setDescription("This is Telelvis");
        category.setImageURL("dsfds");
    	categories.add(category);
   
    	

	}

	@Override
	public List<Category> list() {

		return categories;
	}

	@Override
	public Category get(int id) {
		
		for(Category category : categories){
			
			if(category.getId() == id){
				
				 if(category.getId() == id) 
					return category;
			}
		}
		
		return null;
	}

}
