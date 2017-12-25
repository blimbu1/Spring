package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPropertyInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// configure spring container
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean
		SwimCoach swimteam = context.getBean("swimCoach",SwimCoach.class);
		
		// Use the bean
		System.out.println(swimteam.getDailyFortune());
		
		swimteam.getEmail();
		
		swimteam.getTeam();

		//close the context
		context.close();
	}

}