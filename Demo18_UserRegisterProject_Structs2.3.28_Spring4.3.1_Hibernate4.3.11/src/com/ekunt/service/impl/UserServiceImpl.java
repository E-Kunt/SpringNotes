package com.ekunt.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.ekunt.dao.UserDao;
import com.ekunt.entity.User;
import com.ekunt.service.UserService;

/**
 * 用户业务逻辑实现类
 * @author E-Kunt
 *
 */
@Component("userService")
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Override
	public boolean exist(User user) {
			boolean isExist = userDao.exist(user);
			return isExist;
	}
	
	@Override
	public boolean add(User user) {
			boolean isSuccess = false;
			userDao.save(user);
			isSuccess = true;
			return isSuccess;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
