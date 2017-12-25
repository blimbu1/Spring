package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// if you put the @Component annotaion the Classes are 
// instantiated even if they are not directly retrieved 
// using the context.getBean() method.

@Component
public class GuitarCoach implements Coach {
	
	//@Autowired
	
	private FortuneService fortuneService;
	
	// define a default constructor
	public GuitarCoach() {
		System.out.println("GuitarCoach: Inside the default constructor");
	}
	
	// define a setter method for dependency injection
	// @Qualifier seems to work with method injection and parameter injection
	
	@Autowired
	@Qualifier("happyFortuneService")
	public void doSomeCrazyStuff(FortuneService thefortune) {
		System.out.println("GuitarCoach: Inside doSomeCrazyStuff");
		fortuneService = thefortune;
	}
	

	@Override
	public String getDailyWorout() {
		// TODO Auto-generated method stub
		return "Practice strumming 20 minutes a day";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}