package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.FortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		FortuneService theFortuneService = context.getBean("fortuneService", FortuneService.class);
		
		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("Calling getFortune");
		
		// Use the function
		String fortune = theFortuneService.getFortuneService();
		
		System.out.println("\nMy Fortune is: " + fortune);
		
		System.out.println("Finished");
		// close the context
		context.close();
	}

}
