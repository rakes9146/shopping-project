package net.rk.shopping_backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.rk.shopping_backend.dao.UserDAO;
import net.rk.shopping_backend.dto.Address;
import net.rk.shopping_backend.dto.Cart;
import net.rk.shopping_backend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory SessionFactory;

	@Override
	public boolean addUser(User user) {

		try {
			SessionFactory.getCurrentSession().persist(user);
			return true;

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {

		try {
			SessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public User getByEmail(String email) {

		String selectQuery = "FROM User WHERE email = :email";

		try {

			return SessionFactory.getCurrentSession().createQuery(selectQuery, User.class).setParameter("email", email)
					.getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Address getAddress(int addressId) {
		try {
			return SessionFactory.getCurrentSession().get(Address.class, addressId);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :isBilling";
		try {
			return SessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
					.setParameter("userId", userId).setParameter("isBilling", true).getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		try {
			SessionFactory.getCurrentSession().update(address);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public User get(int id) {
		try {
			return SessionFactory.getCurrentSession().get(User.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {

		String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :isShipping ORDER BY id DESC";
		return SessionFactory.getCurrentSession().createQuery(selectQuery, Address.class).setParameter("userId", userId)
				.setParameter("isShipping", true).getResultList();
	}

}
