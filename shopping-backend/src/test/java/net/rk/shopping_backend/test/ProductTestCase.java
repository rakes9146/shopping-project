package net.rk.shopping_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.rk.shopping_backend.dao.ProductDAO;
import net.rk.shopping_backend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.rk.shopping_backend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");

	}

	/*
	 * @Test public void testCRUDProduct() {
	 * 
	 * product = new Product();
	 * 
	 * product.setName("Oppo Selfie S53"); product.setBrand("Oppo");
	 * product.setDescription("This description for oppo mobile phones");
	 * product.setUnitPrice(25000); product.setActive(true);
	 * product.setCategoryId(3); product.setSupplierId(3);
	 * 
	 * assertEquals("Something went wrong while inserting the product", true,
	 * productDAO.add(product));
	 * 
	 * // reading and updating the product
	 * 
	 * product = productDAO.get(2); product.setName("Samsung Galaxy S7");
	 * assertEquals("Something went wrong while updaing the existing record",
	 * true, productDAO.update(product));
	 * 
	 * assertEquals("Something went wrong while deleting the  record", true,
	 * productDAO.delete(product));
	 * 
	 * // list
	 * assertEquals("Something Went wrong while fetching the list of prpoducts",
	 * 6, productDAO.list().size()); }
	 */
	@Test
	public void testListActiveProduct() {

		assertEquals("Something Went wrong while fetching the list of prpoducts", 6,
				productDAO.listActiveProducts().size());

	}

	@Test
	public void testListActiveProductByCategory() {

		assertEquals("Something went wrong while fetching the list of product", 3,
				productDAO.listActiveProductsByCategory(3).size());

		assertEquals("Something went wrong while fetching the list of product", 2,
				productDAO.listActiveProductsByCategory(1).size());

	}

	@Test
	public void testGetLatestActiveProduct() {

		assertEquals("Something went wrong while fetching the list of products", 3,
				productDAO.getLatestActiveProducts(3).size());
	}

}
