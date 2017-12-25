package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
	
	private String fileName = "/home/binay/Documents/fotrune.txt";
	
	private List<String> theFortunes;
	
	// create a random number generator
	private Random myRandom = new Random();
	
	public DatabaseFortuneService() {
		File theFile = new File(fileName);
		
		System.out.println("Reading fortunes from file: " + theFile.getName());
		
		System.out.println("File exists: " + theFile.exists());
		
		// initialize array list
		theFortunes = new ArrayList<String>();
		
		// read fortunes from file
		try(BufferedReader br = new BufferedReader(new FileReader(theFile))){
			String tempLine;
			while((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
				
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String getFortune() {
		
		int index = myRandom.nextInt(theFortunes.size());
		// TODO Auto-generated method stub
		
		String tempFortune = theFortunes.get(index);
		
		return tempFortune;
	}

}
