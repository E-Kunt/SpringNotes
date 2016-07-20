package com.ekunt.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ekunt.dao.LogDao;
import com.ekunt.dao.UserDao;
import com.ekunt.entity.Log;
import com.ekunt.entity.User;

/**
 * User业务逻辑类
 * @author E-Kunt
 *
 */
@Scope("singleton")  //生命范围
@Component  //声明bean
public class UserService {
	private UserDao userDao;
	private LogDao logDao;
	
	public UserService() {

	}

	public UserService(UserDao dao) {
		this.userDao = dao;
	}
	
	@Resource(name="userDao")  //属性注入，可以指定要注入的bean的名称
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Resource(name="logDao")
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public LogDao getLogDao() {
		return logDao;
	}
	
	public void add(User user) {
		userDao.save(user);
		logDao.save(new Log("Add a user("+ user.getName() +") !"));
	}
	
	@PostConstruct //初始化方法
	public void init() {
		System.out.println("UserService : initial.");
	}

	@PreDestroy //销毁方法
	public void destroy() {
		System.out.println("UserService : destroy.");
	}

}
