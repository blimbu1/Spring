package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	
	// create an array of Strings
	private String[] data = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"Be present of the journey"
	};
	
	// create a random number generator
	
	private Random ran = new Random();
	

	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = ran.nextInt(data.length);
		String thefort = data[index];
		return thefort;
	}

}
