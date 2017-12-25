package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor in your class for dependency injections
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override	
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}
	@Override	
	public String motivation() {
		return "Don't swing hard, don't swing fast, swing RIGHT";
	}
	@Override
	public String getDailyFortune() {
		
		//use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
