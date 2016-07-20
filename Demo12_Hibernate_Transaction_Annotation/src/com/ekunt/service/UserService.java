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
	
	//添加Spring事务管理（有RuntimeException时会自动回滚。）所有属性可选。
	@Transactional(
			propagation=Propagation.REQUIRED, //事务传播方式：默认情况下为REQUIRED，在原事务中执行，若无则创建新事务执行。
			readOnly=false, //该事务是否只含只读操作。用于优化。
			isolation=Isolation.DEFAULT, //事务的隔离级别。
			timeout=999999, //事务响应时间
			rollbackFor=RuntimeException.class, //发生该异常时，回滚
			noRollbackFor=NumberFormatException.class //发送该异常时，不回滚
			)
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
