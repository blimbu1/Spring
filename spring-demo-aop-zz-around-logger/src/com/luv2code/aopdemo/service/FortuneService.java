package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {
	
	public String getFortuneService(){
		
		try {
			
			TimeUnit.SECONDS.sleep(5);			
		}
		catch (InterruptedException e){
			
			e.printStackTrace();
			
		}
		
		return "expect heavy rain Today";
	}

}
