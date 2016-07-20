package com.ekunt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

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
	
	private DataSource dataSource;
	
	@Override
	public void add(User user) {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into user values(null,?,?)");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPasswd());
			pstmt.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("UserDaoImpl : Add a user!");
	}

	@Resource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

}
