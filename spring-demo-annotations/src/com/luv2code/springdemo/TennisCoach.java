package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")

//@Scope("prototype") removing scope for this particular exercise.
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// Spring will look for classes that implements Fortuneservice 
	// Create an object and then inject it.
	
/*  // I cannot seem to be able to use @Qualifier with constructor Injection
 	// update: Can use @Qualifier in Constructor. Shown Below
	public TennisCoach(@Qualifier("randomFortuneService) FortuneService fortune) {
		fortuneService = fortune;
	}
	
*/
	
	public TennisCoach() {
		System.out.println("TennisCoach: Inside the default constructor");
	}
	
	// define my init method
	@PostConstruct //method must be void
	public void doMyStartUpStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartUpStuff()");
	}
	
	
	// define my destroy method
	@PreDestroy //method must be void
	public void doMyCleanUpStuff() {
		System.out.println(">>TennisCoach: inside of doMyCleanupStuff()");
	}
	
	@Override
	public String getDailyWorout() {
		
		return "Practice your backhand Volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	


}
