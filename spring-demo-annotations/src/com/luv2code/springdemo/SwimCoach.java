package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class SwimCoach implements Coach {
	
	
	private FortuneService randomService;
	
	// @Value is used to read property from sport.properties
	
	@Value("${foo.email}")	
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	// Autowired should be with the constructor not the reference variable
	
	@Autowired
	public SwimCoach(@Qualifier("randomFortuneService") FortuneService fortune) {
		randomService = fortune;
	}

	@Override
	public String getDailyWorout() {
		// TODO Auto-generated method stub
		return "Swim 50 laps daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return randomService.getFortune();
	}
	
	public void getEmail() {
		System.out.println("The email is: " + email);
	}
	
	public void getTeam() {
		System.out.println("The team is: "+ team);
	}
	
	

}
