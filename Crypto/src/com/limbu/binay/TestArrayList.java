package com.limbu.binay;

import java.util.ArrayList;

public class TestArrayList {
	
	public static void main(String a[]) {
		ArrayList<String> a1 = new ArrayList<String>();
		
		// Adding elements to the ArrayList
		a1.add("Apple");
		a1.add("Orange");
		a1.add("Mango");
		a1.add("Grapes");
		System.out.println("ArrayList: " +a1);
		
		ArrayList<String> a2 = (ArrayList<String>)a1.clone();
		System.out.println("Shallow Copy of ArrayList: " + a2);
		
		ArrayList<String> a3 = new ArrayList<String>(a1);
		System.out.println("Copying again "+a3);
		
		//add and remove on original list
		a1.add("Fig");
		a1.remove("Orange");
		
		//Display of both Arraylist
		
		System.out.println("Original ArrayList: " +a1);
		System.out.println("Cloned ArrayList: "+a2);
		System.out.println("Second Copy: "+a3);
		
	}

}
