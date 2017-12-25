package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActivityFive {

	public static void main(String[] args) {
		
		// configure the spring container
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("tastapplicationContext.xml");
		
		
		
		// retrieve the bean
		Coach aCoach = context.getBean("archeryCoach",Coach.class);
	
		
		// use the bean
		System.out.println(aCoach.getDailyFortune());
		
		
		//close the BEan
		context.close();
	}

}