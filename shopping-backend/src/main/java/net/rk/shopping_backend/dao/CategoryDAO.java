package net.rk.shopping_backend.dao;

import java.util.List;

import net.rk.shopping_backend.dto.Category;


public interface CategoryDAO {

	  public List<Category> list();
	  public Category get(int id);
	
}
