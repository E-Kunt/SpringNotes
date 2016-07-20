package com.ekunt.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import com.ekunt.dao.LogDao;
import com.ekunt.entity.Log;

@Component("logDao")
public class LogDaoImpl  implements LogDao{
	
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Log log) {
		Session session = sessionFactory.getCurrentSession();
		session.save(log);
		System.out.println("LogDao txHash:" + session.getTransaction().hashCode()); //调试用，看是否与其他DAO操作在同个事务中。
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
