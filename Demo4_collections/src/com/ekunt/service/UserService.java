package com.ekunt.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.ekunt.dao.UserDao;
import com.ekunt.entity.User;

/**
 * UserÒµÎñÂß¼­Àà
 * @author E-Kunt
 *
 */
public class UserService {
	private UserDao dao;
	private Properties properties;
	private Set<String> sets;
	private List<String> lists;
	private Map<String,UserDao> maps;
	
	public UserService(UserDao dao) {
		this.dao = dao;
	}

	public UserService() {

	}
	
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Set<String> getSets() {
		return sets;
	}

	public void setSets(Set<String> sets) {
		this.sets = sets;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Map<String, UserDao> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, UserDao> maps) {
		this.maps = maps;
	}

	public void add(User user) {
		System.out.println("UserService : ready to add a user!");
		dao.add(user);
	}

	@Override
	public String toString() {
		return "UserService : properties size=" + properties.size() + ", sets size=" + sets.size() + ", lists size=" + lists.size()
				+ ", maps size=" + maps.size();
	}
	
}
