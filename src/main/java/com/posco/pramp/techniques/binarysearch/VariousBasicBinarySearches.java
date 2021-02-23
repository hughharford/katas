package com.posco.pramp.techniques.binarysearch;

import java.util.Arrays;

public class VariousBasicBinarySearches {

	public static void main(String[] args) {
		int[] ourArray = randomSortedArrayLengthN(1000);
		System.out.println(Arrays.toString(ourArray));

		// int ourI = indexEqualsValueSearch(ourArray);

		int key = 18;
		int ourI = basicBinarySearch(ourArray, key);

		System.out.println("Key: " + key + "  ourI = " + ourI);
	}

	private static int basicBinarySearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int i;

		while (start <= end) {
			i = Math.round((start+end)/2); 		// check-point at array middle
			if      (key < arr[i])   end = i-1; // search array's RHS
			else if (key > arr[i]) start = i+1; // search array's LHS
			else return i;
		}
		return -1;
	}

	private static int indexEqualsValueSearch(int[] arr) {
		

		
		int start = 0;
		int end = arr.length - 1;
		int i;

		while (start <= end) {
			i = Math.round((start+end)/2); // sets the check-point at array middle
			if (arr[i] - i < 0) {
				start = i+1;   // if i > the index, search array's RHS
			} else if (

					(arr[i] - i == 0)    
					&& 					// first point, & index == value
					(i == 0) 
					|| 
					(arr[i-1] - (i-1) < 0)  // index == value at i

					) {
				return i;
			} else {
				end = i-1; // if i > the index, search array's LHS
			}
		}
		return -1;
	}

	private static int[] randomSortedArrayLengthN(int n) {
		int[] intArray = new int[n];
		double x = 0;

		for (int i = 0; i < n; i++) {
			x = Math.random() * 1000;
			intArray[i] = (int) Math.floor(x);
		}
		Arrays.sort(intArray);
		return intArray; 
	}

	private static int[] indexEqualsValueSortedArrayLengthN(int n) {
		int[] intArray = new int[n];
		for (int i = 0; i < n; i++) {
			intArray[i] = i;
		}
		Arrays.sort(intArray);
		return intArray; 
	}
}
