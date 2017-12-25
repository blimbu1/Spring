package com.luv2code.springdemo;

import java.util.Random;

public class MotivationQuotes implements Quotes {
	
	private String[] saying = {"I don't want perfection I want effort", "The only bad work out is the work out that didn't happen",
			"Diligence, persistence, perseverence, consistency what ever you want to call it is the key to all successes"};
	
	private Random ren = new Random();

	@Override
	public String inspiring() {
		// TODO Auto-generated method stub
		int gen = ren.nextInt(saying.length);
		return saying[gen];
	}

}
