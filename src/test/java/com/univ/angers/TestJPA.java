package com.univ.angers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testJPA() {
		try {
			ClassPathXmlApplicationContext app= 
					new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			//si l'opération reussi
			assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			assertTrue(e.getMessage(),false);

		}
		
	}

}
