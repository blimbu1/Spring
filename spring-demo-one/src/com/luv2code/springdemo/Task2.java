package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new	ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach baddie = context.getBean("BadCoach",BadmintionCoach.class);
		
		// retrieving the first method from the Object
		System.out.println(baddie.getDailyFortune());

		//retrieving the second method from the object
		System.out.println(baddie.getDailyWorkout());
		
		// retrieving the motivation quotes
		System.out.println(baddie.motivation());
		
		// Always close the context
		context.close();
		

	}

}
