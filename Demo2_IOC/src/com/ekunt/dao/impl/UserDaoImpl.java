package com.ekunt.dao.impl;

import com.ekunt.dao.UserDao;
import com.ekunt.entity.User;

/**
 *  DAO具体实现类
 * @author E-Kunt
 *
 */
public class UserDaoImpl implements UserDao {
	/**
	 * 此属性只为说明：简单类型属性在XML中的配置。
	 */
	private String testProperty;
	
	@Override
	public void add(User user) {
		System.out.println("UserDaoImpl : testProperty = " + testProperty );
		System.out.println("UserDaoImpl : Add a user!");
	}

	public String getTestProperty() {
		return testProperty;
	}

	public void setTestProperty(String testProperty) {
		this.testProperty = testProperty;
	}
}
