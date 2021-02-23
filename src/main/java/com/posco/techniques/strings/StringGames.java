package com.posco.techniques.strings;

public class StringGames {

	public static void main(String[] args) {
		// findSecondIndex();

		String in = "abcddefgfhi";
		findLowestIndexOfRepeatedChar(in);
		
	}
	
	private static void findLowestIndexOfRepeatedChar(String s) {
		
		String vowels = "aeiou";
		int lowestIndex = s.length();
		
		System.out.println("findLowestIndexOfRepeatedChar: \n\n");
		for (int i = 0; i < s.length(); i++) {
			
			// System.out.println(vowels.contains(Character.toString(s.charAt(i))));
			
			if (s.indexOf(s.charAt(i), i+1) != -1) {
				System.out.println(s.charAt(i));
				System.out.println(s.indexOf(s.charAt(i)));
				
				if (i < lowestIndex) {
					lowestIndex = i;
				}
			}
		}
		System.out.println("lowestIndex: " + lowestIndex);
		
		System.out.println();
		
	}

	private static void findSecondIndex() {
		String s = "abbb";
		System.out.println(s.indexOf('a'));
		System.out.println(s.indexOf('a',1));

	}

}
