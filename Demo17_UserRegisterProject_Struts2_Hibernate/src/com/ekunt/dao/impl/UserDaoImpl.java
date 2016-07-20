package com.ekunt.dao.impl;

import org.hibernate.Session;
import com.ekunt.dao.UserDao;
import com.ekunt.entity.User;
import com.ekunt.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean exist(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		long num = (long) session.createQuery("select count(*) from User u where u.user = :user")
				.setString("user", user.getUser()).uniqueResult();
		return num > 0 ? true : false;
	}

	@Override
	public void save(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.save(user);
	}

}
