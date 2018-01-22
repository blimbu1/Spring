package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	private String fileName = "/home/binay/Documents/fotrune.txt";
	
	private List<String> theFortunes;
	
	private Random myRandom = new Random();
	
	// creating a PostConstruct
	@PostConstruct
	public void StartWithThis() {
		
		File theFile = new File(fileName);
		System.out.println("Reading from file: " + theFile.getName());
		System.out.println("The file exists: " + theFile.exists());
		
		theFortunes = new ArrayList<String>();
		
		 	
		try(BufferedReader br = new BufferedReader(new FileReader(theFile))){
			String tempLine;
			while((tempLine = br.readLine())!= null) {
				theFortunes.add(tempLine);
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getFortune() {
		
		System.out.println("FileFortuneService: Inside getFortune ");
		int index = myRandom.nextInt(theFortunes.size());
		
		String tempFortune = theFortunes.get(index);
		return tempFortune;
	}

}
