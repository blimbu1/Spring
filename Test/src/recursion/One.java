package recursion;

import java.util.ArrayList;

public class One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> permutations = getPermutations("abc");
		
		assert permutations.size() == 6;
		assert permutations.contains("abc");
		assert permutations.contains("acb");
		assert permutations.contains("bac");
		assert permutations.contains("bca");
		assert permutations.contains("cab");
		assert permutations.contains("cba");
		
		System.out.println("Tests Passed");
		System.out.println(permutations);

	}
	
	public static ArrayList<String> getPermutations(String text){
		
		ArrayList<String> results = new ArrayList<String>();
		
		//the base case
		if (text.length() == 1) {
			results.add(text);
			return results;
		}
		
		for (int i=0; i<text.length(); i++) {
			char first = text.charAt(i);
			System.out.println("first: " + first);
			String remains = text.substring(0, i) + text.substring(i+1);
			System.out.println("remains: " + remains);
			
			ArrayList<String> innerPermutations = getPermutations(remains);
			System.out.println(innerPermutations);
			
			for (int j=0; j<innerPermutations.size();j++) {
				System.out.println(first + innerPermutations.get(j));
				results.add(first + innerPermutations.get(j));
			}
		}
		return results;
	}

}
