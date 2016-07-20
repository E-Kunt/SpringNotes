package com.ekunt.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP。织入日志功能。
 * @author E-Kunt
 *
 */
@Aspect //声明切面
@Component //声明bean
public class LogInterceptor {
	@Pointcut("execution(public * com.ekunt.dao..*.*(..))") //切面点的组合，取名为log()。
	public void log(){}
	
	@Before("log()") //方法执行前执行。
	public void before() {
		System.out.println("Log : Before method start !");
	}
	
	@After("log()")  //方法执行后执行。
	public void after() {
		System.out.println("Log : After method end !");
	}
	
	@Around("log()")  //方法执行前、后，执行相应部分代码。
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Log : Around before !");
		pjp.proceed();
		System.out.println("Log : Around after !");
	}
	
	@AfterReturning("log()") //方法返回后执行。
	public void afterReturning() {
		System.out.println("Log : After returning !");
	}

	@AfterThrowing("log()") //方法抛异常后执行。
	public void afterThrowing() {
		System.out.println("Log : After throwing !");
	}
	
}
