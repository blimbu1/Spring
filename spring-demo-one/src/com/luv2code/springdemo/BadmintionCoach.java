package com.luv2code.springdemo;

public class BadmintionCoach implements Coach{
	
	private MotivationQuotes motivation;
	
	public BadmintionCoach() {
		System.out.println("In the BadmintonCoach Constructor");
	}
	
	public BadmintionCoach(MotivationQuotes motive) {
		System.out.println("I am not in the default constructor");
		this.motivation = motive;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practise smashing for 30 minutes";
	}
	
	@Override
	public String getDailyFortune() {
		return "Hello";
		
	}
	
	@Override
	public String motivation() {
		return motivation.inspiring();
		
	}
	
	public void startWithThis() {
		System.out.println("Welcome to BadmintonCoach");
	}
	
	public void closeWithThis() {
		System.out.println("Sorry but I do not work with Prototypes");
		
	}
	public void sayHello() {
		System.out.println("Hello!!");
	}

}
