package com.ekunt.dao.impl;

import javax.annotation.Resource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ekunt.dao.UserDao;
import com.ekunt.entity.User;

/**
 * 用户数据访问对象实现类
 * @author E-Kunt
 *
 */
@Component("userDao")
public class UserDaoImpl implements UserDao {
	
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean exist(User user) {
		String hql = "select count(*) from User u where u.user = :user";
		long result = (long) hibernateTemplate.findByNamedParam(hql, "user", user.getUser()).get(0);
		return result > 0 ? true : false;
	}

	@Override
	public void save(User user) {
		hibernateTemplate.save(user);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}



}
