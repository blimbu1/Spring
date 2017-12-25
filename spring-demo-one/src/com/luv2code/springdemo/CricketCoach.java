package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// add new file for emailAddress and team
	private String emailAddress;
	private String team;
	
	
	// create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside the setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside the setter method - setTeam");

		this.team = team;
	}
	
	// Dependency Injecting using the setter method	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside the setter method");
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String motivation() {
		return null;
	}

}
