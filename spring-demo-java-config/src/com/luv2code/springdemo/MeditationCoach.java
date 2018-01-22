package com.luv2code.springdemo;

public class MeditationCoach implements Coach {
	
	private FortuneService meditate;
	
	// constructor is need. 
	// spring only creates an object PresenceFortuenService
	// needs to be assigned manually
	public MeditationCoach(PresenceFortuneService myPresence) {
		meditate = myPresence;
	}



	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do Body Scan for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return meditate.getFortune();
	}

}
