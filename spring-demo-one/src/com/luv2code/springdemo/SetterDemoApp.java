package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// retrieve bean from spring container
		CricketCoach cricketobject = context.getBean("Cricket",CricketCoach.class);
		
		
		// call methods on the bean
		//.....coming back to this later......
		System.out.println(cricketobject.getDailyFortune());
		
		System.out.println(cricketobject.getDailyWorkout());
		
		
		// call our ned methods to get literal valuse
		System.out.println(cricketobject.getEmailAddress());
		
		System.out.println(cricketobject.getTeam()); 
		
		
		//close the context
		context.close();
		

	}

}
