package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.FortuneService;

public class AroundWithLoggerDemoApp {
	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		FortuneService theFortuneService = context.getBean("fortuneService", FortuneService.class);
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		// Use the function
		String fortune = theFortuneService.getFortuneService();
		
		myLogger.info("\nMy Fortune is: " + fortune);
		
		myLogger.info("Finished");
		// close the context
		context.close();
	}

}
