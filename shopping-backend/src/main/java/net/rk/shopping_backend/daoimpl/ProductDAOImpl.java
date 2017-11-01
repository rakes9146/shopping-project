package net.rk.shopping_backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.rk.shopping_backend.dao.ProductDAO;
import net.rk.shopping_backend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	// This method will used to get Category By Id
	@Override
	public Product get(int productId) {
		try {

			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));

		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return null;
	}

	// This method will get the list of products
	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("From product", Product.class).getResultList();
	}

	// this method used to add the products
	@Override
	public boolean add(Product product) {

		try {

			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}

	// this method used to udpate the products
	@Override
	public boolean update(Product product) {

		try {

			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;
	}

	// this method used to delete the product
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	// this method get the active products list
	@Override
	public List<Product> listActiveProducts() {

		String selectActiveProducts = "FROM product WHERE active =:active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}

	// this method will give list of the active products
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {

		String selectActiveProductsByCategory = "FROM product WHERE active =:active AND categoryId =:categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();

	}

	// this method get the latest active producs
	@Override
	public List<Product> getLatestActiveProducts(int count) {

		return sessionFactory.getCurrentSession()
				.createQuery("FROM propduct WHERE active =:active ORDER BY id", Product.class)
				.setParameter("active", true).setFirstResult(count).getResultList();
	}

}
