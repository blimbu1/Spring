package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActivitySix {

	public static void main(String[] args) {
		
		// creating the spring container
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("tastapplicationContext.xml");
		
		// retrieving the Bean
		FortuneService today = context.getBean("fileFortuneService",FortuneService.class);

		// using the Bean
		System.out.println(today.getFortune());
		
		// close the context
		context.close();
	}

}
