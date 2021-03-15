package com.posco.codesignal.iscryptsolution;

import java.util.Arrays;
import java.util.HashMap;

public class CryptSolution {

	public static void main(String[] args) {
		CryptSolution cs = new CryptSolution();
		// String[] crypt = {"SEND", "MORE", "MONEY"};
		String[] crypt = {"TEN", "TWO", "ONE"};
		char[][] sol = cs.getSolution();

		// HashMap<Character,Integer> solEncode = cs.encodeSolution(sol);

	
		System.out.println(cs.isCryptSolution(crypt, sol));
	}

	boolean isCryptSolution(String[] crypt, char[][] solution) {
		if (solution.length == 0 || solution[0].length == 0 || solution[1].length == 0) return false;

		HashMap<Character,Character> solEncode = encodeSolution(solution);
		
		int[] sumArray = {0,0,0};
		String working = "";
		for (int i = 0; i < crypt.length; i++) {
			for (int j = 0; j < crypt[i].length(); j++) {
				// System.out.print(crypt[i].charAt(j) + " ");
				char key = crypt[i].charAt(j);
				// System.out.println(solEncode.get(key));
				char charToAdd = solEncode.get(key);
				if (charToAdd == '0' && j == 0 && crypt[i].length() != 1) return false; //leading zero
				working = working + charToAdd;
				sumArray[i] = Integer.parseInt(working);
			}
			// System.out.println(working);
			working = "";
		}
		System.out.println(sumArray[2]);
		System.out.println(sumArray[1]);
		System.out.println(sumArray[0]);

		return (sumArray[2] == sumArray[0] + sumArray[1]);
	}
	
	private HashMap<Character,Character> encodeSolution(char[][] solution) {
		HashMap<Character,Character> charInt = new HashMap<>();
		for (int i = 0; i < solution.length; i++) {
			// System.out.println(solution[i][0] + "," + solution[i][1] + " now gives: " + Character.getNumericValue(solution[i][1]));
			charInt.put(solution[i][0], solution[i][1]); 
		}
		return charInt;
	}
	
	private char[][] getSolution() {
		char[][] solution1 = {{'O', '0'},
		                     {'M', '1'},
		                     {'Y', '2'},
		                     {'E', '5'},
		                     {'N', '6'},
		                     {'D', '7'},
		                     {'R', '8'},
		                     {'S', '9'}};
		

		char[][] solution2 = {{'O','1'}, 
							 {'T','0'}, 
							 {'W','9'}, 
							 {'E','5'}, 
							 {'N','4'}};
		return solution2;
	}
	
}
