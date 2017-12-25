package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// setting up the spring config/container
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScopebeanLifeCycleTask.xml");
		
		
		// retrieving the bean
		BadmintionCoach bads = context.getBean("BadCoach",BadmintionCoach.class);
		
		BadmintionCoach bad1 = context.getBean("BadCoach",BadmintionCoach.class);
		
		// Using a function in the bean
		System.out.println(bads.motivation());
		
		System.out.println(bad1.motivation());
		
		bads.sayHello();
		
		// Close the context
		context.close();
		
		

	}

}
