package com.ekunt.service.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ekunt.dao.UserDao;
import com.ekunt.dao.impl.UserDaoImpl;
import com.ekunt.entity.User;
import com.ekunt.service.UserService;
import com.ekunt.util.HibernateUtil;

public class UserServiceImpl implements UserService {
	
	private static volatile UserService userService = null;
	private UserDao userDao = new UserDaoImpl();
	
	private UserServiceImpl() {
	}
	
	public static UserService getInstance() {
		if(userService == null) {
			synchronized (UserService.class) {
				if(userService==null) {
					userService = new UserServiceImpl();
				}
			}
		}
		return userService;
	}

	@Override
	public boolean exist(User user) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			boolean isExist = userDao.exist(user);
			session.getTransaction().commit();
			return isExist;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return true;
		}
	}
	
	@Override
	public boolean add(User user) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			userDao.save(user);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
