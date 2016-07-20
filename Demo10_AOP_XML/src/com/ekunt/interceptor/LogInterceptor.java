package com.ekunt.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * AOP。织入日志功能。
 * @author E-Kunt
 *
 */
public class LogInterceptor {
	public void before() {
		System.out.println("Log : Before method start !");
	}
	
	public void after() {
		System.out.println("Log : After method end !");
	}
	
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Log : Around before !");
		pjp.proceed();
		System.out.println("Log : Around after !");
	}
	
	public void afterReturning() {
		System.out.println("Log : After returning !");
	}
	
	public void afterThrowing() {
		System.out.println("Log : After throwing !");
	}
	
}
