package com.ekunt.dao.impl;

import org.springframework.stereotype.Component;
import com.ekunt.dao.LogDao;
import com.ekunt.entity.Log;

@Component("logDao")
public class LogDaoImpl extends SuperDaoImpl implements LogDao{
	
	@Override
	public void save(Log log) {
		this.getHibernateTemplate().save(log);
	}

}
