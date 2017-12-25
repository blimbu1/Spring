package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// get the bean from spring container stating the bean explicitly i.e. thatSillyCoach
		Coach theCoach = context.getBean("thatSillyCoach",Coach.class);
		
		//getting the bean using default id
		Coach gCoach = context.getBean("guitarCoach",Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorout());
		
		System.out.println("GuitarCoach: " + gCoach.getDailyWorout());
		
		// call the method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("GuitarCoach: " + gCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
