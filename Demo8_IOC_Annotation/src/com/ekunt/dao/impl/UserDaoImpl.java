package com.ekunt.dao.impl;

import org.springframework.stereotype.Component;
import com.ekunt.dao.UserDao;
import com.ekunt.entity.User;

/**
 *  DAO具体实现类
 * @author E-Kunt
 *
 */
@Component("dao") //声明bean 可以指定id
public class UserDaoImpl implements UserDao {
	
	@Override
	public void add(User user) {
		System.out.println("UserDaoImpl : Add a user!");
	}

}
