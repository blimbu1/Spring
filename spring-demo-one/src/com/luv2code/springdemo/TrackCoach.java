package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	// Defining a private field for dependency
	private FortuneService grateful;
	
	public TrackCoach() {}
	// Defining a constructor in class for dependency injection
	public TrackCoach(FortuneService grate) {
		grateful = grate;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}
	
	public String motivation() {
		return "Go hard or Go Home";		
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just Do It: " + grateful.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMysStartupStuff");
	}
	
	
	// add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");
	}
}
