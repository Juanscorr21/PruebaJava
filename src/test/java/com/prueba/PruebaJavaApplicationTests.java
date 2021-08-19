package com.prueba;


import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.model.User;
import com.prueba.service.UserService;



@SpringBootTest
class PruebaJavaApplicationTests {
	
	
	@Mock
	UserService userService;
	
	@Test
	public void testUser(){	
		User user = new User();
	 	user.setId((long) 19);
		user.setName("camila");
		user.setLastname("restrepo");
		user.setPhone("132435");
		user.setUserName("res123");
		user.setPassword("Rest123");	
		
		
		assertTrue("Nombre usuario es null", user.getName() != null);	
	}	
}
