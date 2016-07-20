package com.ekunt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 日志实体类
 * @author E-Kunt
 *
 */
@Entity(name="t_Log")
public class Log {
	
	private int id;
	private String msg;

	public Log() {
	}

	public Log(String msg) {
		this.msg = msg;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public String getMsg() {
		return msg;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

	
}
