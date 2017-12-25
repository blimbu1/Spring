package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//load the spring configuration file; setting up spring container
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("ballCoach",Coach.class);
		
		Coach secondCoach = context.getBean("runCoach",Coach.class);
		
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(secondCoach.motivation());
		
		// let's call  our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		System.out.println(secondCoach.getDailyFortune());
		
		
		//close the context
		context.close();
	}

}