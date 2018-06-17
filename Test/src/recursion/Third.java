package recursion;

public class Third {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAnagrams("","abcd");
	}
	
	public static void printAnagrams(String prefix, String word) {
		if(word.length()<=1) {
			System.out.println(prefix + word);
		}
		else {
			for(int i = 0; i<word.length();i++) {
				System.out.println("i="+i);
				String cur = word.substring(i, i+1);
				System.out.println("cur = "+cur);
				String before = word.substring(0,i);
				System.out.println("before = "+before);
				String after = word.substring(i+1);
				System.out.println("after = "+after);
				printAnagrams(prefix+cur, before+after);
				System.out.println("=============================================");
			}
		}
	}

}
