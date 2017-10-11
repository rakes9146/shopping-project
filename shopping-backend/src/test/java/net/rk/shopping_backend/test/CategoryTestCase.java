package net.rk.shopping_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.rk.shopping_backend.dao.CategoryDAO;
import net.rk.shopping_backend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.rk.shopping_backend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}
	/*
	 * @Test public void testAddCategory() {
	 * 
	 * 
	 * assertEquals("Successfully added a category inside the table !",true,
	 * categoryDAO.add(category)); }
	 */
	/*
	 * @Test public void testGetCategory(){
	 * 
	 * category = categoryDAO.get(1);
	 * assertEquals("Successfully Fetched a single category when only when it matches talbe"
	 * ,"Televsion",category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory(){
	 * 
	 * category = categoryDAO.get(1); category.setName("TV");
	 * assertEquals("Successfully Updated a single category when only when it matches talbe"
	 * ,true,categoryDAO.update(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testDeleteCategory(){
	 * 
	 * category = categoryDAO.get(1);
	 * assertEquals("Successfully delete a single category when only when it matches talbe"
	 * ,true,categoryDAO.delete(category));
	 * 
	 * }
	 */
	/*@Test
	public void testListCategory() {

		assertEquals("Successfully fetched the list of category from the table ", 2, categoryDAO.list().size());

	}*/

	@Test
	public void testCRUDCategory() {

		// Add operation test
		category = new Category();
		category.setName("Laptop[");
		category.setDescription("This is Laptop");
		category.setImageURL("DM1.png");
		assertEquals("Successfully added a category inside the table !", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Television");
		category.setDescription("This is Telelvision");
		category.setImageURL("DM2.png");
		assertEquals("Successfully added a category inside the table !", true, categoryDAO.add(category));

		//fetching and updating the category
		 category = categoryDAO.get(2);
		 category.setName("Television");
		 assertEquals("Successfully Updated a single category when only when it matches talbe",true,categoryDAO.update(category));
	
	    //deleting the category
		 category = categoryDAO.get(1);
		 assertEquals("Successfully delete a single category when only when it matches talbe",true,categoryDAO.delete(category));
		 
		//fetching the category list
		 assertEquals("Successfully fetched the list of category from the table ", 1, categoryDAO.list().size());
	}

}
