package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ActivitySeven {

	public static void main(String[] args) {
		
		// Insert the Java Configuration File
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ActivitySevenConfig.class);
				
		
		// Retrieve the Bean
		// Name is the name of function
		Coach mCoach = context.getBean("meditating",Coach.class);
		
		
		// Use the bean
		System.out.println(mCoach.getDailyFortune());
		
		System.out.println(mCoach.getDailyWorkout());
		// close the context
		
		context.close();
	}

}
