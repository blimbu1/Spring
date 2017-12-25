package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ArcheryCoach implements Coach {
	
	private FortuneService fortify;
	
	@Autowired
	public ArcheryCoach(@Qualifier("databaseFortuneService") FortuneService fort) {
		fortify = fort;
	}

	@Override
	public String getDailyWorout() {
		// TODO Auto-generated method stub
		return "Fore Arm Strengthening for 30 mins";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortify.getFortune();
	}

}
