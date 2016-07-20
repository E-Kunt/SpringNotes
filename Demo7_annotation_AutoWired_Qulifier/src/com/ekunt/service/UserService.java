package com.ekunt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ekunt.dao.UserDao;
import com.ekunt.entity.User;

/**
 * User业务逻辑类
 * @author E-Kunt
 *
 */
public class UserService {
	private UserDao dao;
	
	public UserService() {

	}

	public UserService(UserDao dao) {
		this.dao = dao;
	}
	
	@Autowired(required=true) //自动注入属性，指定为必须项
	//@Qualifier("userDao") //指定按名字来注入
	public void setDao(@Qualifier("userDao")UserDao dao) {
		this.dao = dao;
	}
	
	public UserDao getDao() {
		return dao;
	}
	
	public void add(User user) {
		System.out.println("UserService : ready to add a user!");
		dao.add(user);
	}
	
	public void init() {
		System.out.println("UserService : initial.");
	}

	public void destroy() {
		System.out.println("UserService : destroy.");
	}

}
