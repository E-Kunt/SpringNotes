package com.ekunt.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.ekunt.dao.UserDao;
import com.ekunt.entity.User;

/**
 * User业务逻辑类
 * @author E-Kunt
 *
 */
@Scope("singleton")  //生命范围
@Component  //声明bean
public class UserService {
	private UserDao dao;
	
	public UserService() {

	}

	public UserService(UserDao dao) {
		this.dao = dao;
	}
	
	@Resource(name="dao")  //属性注入，可以指定要注入的bean的名称
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	public UserDao getDao() {
		return dao;
	}
	
	public void add(User user) {
		System.out.println("UserService : ready to add a user!");
		dao.add(user);
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
