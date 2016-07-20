package com.ekunt.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ekunt.entity.User;

/**
 * ≤‚ ‘¿‡
 * @author E-Kunt
 *
 */
public class UserServiceTest {

	@Test
	public void testWithSpring() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserService service = (UserService) context.getBean("userService");
		service.add(new User("E-Kunt Wang","456"));
		context.close();
	}
	
}
