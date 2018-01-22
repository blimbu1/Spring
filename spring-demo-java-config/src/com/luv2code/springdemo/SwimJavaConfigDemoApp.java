package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		// get the bean from spring container stating the bean explicitly i.e. thatSillyCoach
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		
		
		//getting the bean using default id
		//Coach gCoach = context.getBean("guitarCoach",Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//System.out.println("GuitarCoach: " + gCoach.getDailyWorout());
		
		// call the method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call new methods
		System.out.println("email: " + theCoach.getEmail());
		
		System.out.println("Team: "+ theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
