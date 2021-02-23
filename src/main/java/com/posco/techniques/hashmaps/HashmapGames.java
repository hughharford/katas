package com.posco.techniques.hashmaps;

import java.util.HashMap;

public class HashmapGames {

	public static void main(String[] args) {

		HashMap<String, Integer> wordsToNum = new HashMap<>();
		
		wordsToNum.put("ONE", 1);
		wordsToNum.put("TWO", 2);
		wordsToNum.put("THREE", 3);
		wordsToNum.put("FOUR", 4);
		
		System.out.println(wordsToNum);
		System.out.println(wordsToNum.get("FOUR"));
		System.out.println();
		System.out.println("Values: " + wordsToNum.values());
		System.out.println("KeySet: " + wordsToNum.keySet());

		System.out.println();
		System.out.println("Remove FOUR...");
		System.out.println(wordsToNum.remove("FOUR"));
		System.out.println(wordsToNum);

		
		System.out.println();
		System.out.println(" counting instances in the hashmap__________");
		System.out.println();


		String s = "something to ssearch";
		HashMap<Character, Integer> thisHashMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character currentChar = s.charAt(i);
			if (thisHashMap.containsKey(currentChar)) {
				thisHashMap.put(currentChar, thisHashMap.get(currentChar) + 1);
			} else {
				thisHashMap.put(currentChar, 1);
			}
		}
		
		Character mostRepeated = ' ';
		int max = 0;
		for (Character key : thisHashMap.keySet()) {
			int currentValue = thisHashMap.get(key);
			if (currentValue > max) {
				mostRepeated = key;
				max = currentValue;
			}
		}
		System.out.println("Most repeated character: " + mostRepeated + " \n number times: " + max);
		
	}

}
