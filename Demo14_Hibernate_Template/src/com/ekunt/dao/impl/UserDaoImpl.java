package com.ekunt.dao.impl;

import org.springframework.stereotype.Component;

import com.ekunt.dao.UserDao;
import com.ekunt.entity.User;

/**
 *  DAO具体实现类
 * @author E-Kunt
 *
 */
@Component("userDao") //声明bean 可以指定id
public class UserDaoImpl extends SuperDaoImpl implements UserDao {
	
	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}
	
}
