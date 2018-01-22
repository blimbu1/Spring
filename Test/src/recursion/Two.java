package recursion;

import java.util.ArrayList;

public class Two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> binay = new ArrayList<String>();
		binay = permutations("abcd");
		System.out.println(binay);
		System.out.println(binay.size());

	}
	
	public static ArrayList<String> permutations(String s){
		ArrayList<String> results = new ArrayList<String>();
		permutations("",s,results);
		System.out.println("hello");
		return results;
		
	}
	
	private static void permutations(String prefix, String suffix, ArrayList<String> results) {
		if (suffix.length() == 0) {
			System.out.println("printing prefix: " + prefix);
			results.add(prefix);
		}
		else {
			for (int i=0; i<suffix.length(); i++) {
				System.out.println(i);
				System.out.println((prefix + suffix.charAt(i))+ "    " + (suffix.substring(0, i) + suffix.substring(i+1, suffix.length())) + "     " + results);
				permutations(prefix + suffix.charAt(i),suffix.substring(0, i) + suffix.substring(i+1, suffix.length()),results);
			}
		}
		
	}

}
