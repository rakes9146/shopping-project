package net.rk.shopping_backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.rk.shopping_backend.dao.CategoryDAO;
import net.rk.shopping_backend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active =:active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/*
	 * Getting single category based on the id
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	// Adding new category
	@Override
	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// Updating the single category
	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// This methodd will delete the category
	@Override
	public boolean delete(Category category) {

		category.isActive(false);

		try {
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
