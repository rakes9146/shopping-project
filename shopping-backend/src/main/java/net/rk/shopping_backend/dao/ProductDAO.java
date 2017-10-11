package net.rk.shopping_backend.dao;

import java.util.List;

import net.rk.shopping_backend.dto.Product;

public interface ProductDAO {
 
	 Product get(int productId);
	 List<Product> list();
	 boolean add(Product product);
	 boolean update(Product product);
	 boolean delete(Product product);
	 
	 //business methodas
	 List<Product> listActiveProducts();
	 List<Product> listActiveProductsByCategory(int categoryId);
	 List<Product> getLatestActiveProducts(int count); 
	 
	
}
