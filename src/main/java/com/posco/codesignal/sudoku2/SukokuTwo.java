package com.posco.codesignal.sudoku2;

import java.util.HashMap;

public class SukokuTwo {
	
	private boolean printOut = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SukokuTwo suk = new SukokuTwo();
		// suk.sudoku2(suk.getInput());

		// suk.sLoops(suk.getInput());
		System.out.println("sudoku2 = " + suk.sudoku2(suk.getInput()));
		
		
	}
	
	boolean sudoku2(char[][] grid) {
		boolean canSudoku = false;
		
		canSudoku = sLoopAndCheckOneToNine(grid);
		
		return canSudoku;
	}
	
	
	private boolean sLoopAndCheckOneToNine(char[][] grid) {
		// 3 x 3 loops (9 of)
		int startR = 0;
		int startC = 0;
		
		for (int m = 0; m < 3; m++) {
			
			for (int k = 0; k < 3; k++) {
				if (printOut) System.out.println(">>>>>>>>>>>> " + startR + ", " + startC);
	
				// 3 x 3 squares
				HashMap<Integer,Integer> threeXthree = new HashMap<>();
				for (int i = startR; i < startR+3; i++) {
					for (int j = startC; j < startC+3; j++) {
						if (printOut) System.out.print(i + "," + j + ": " + grid[i][j] + "   ");
						if (!String.valueOf(grid[i][j]).equals(".")) {
							int key = Integer.parseInt(String.valueOf(grid[i][j]));
			            	if (!threeXthree.containsKey(key)) threeXthree.put(key, 1);
			            	else {
			            		threeXthree.put(key,threeXthree.get(key) + 1);
			            		return false; // i.e. > 1 instance of any number
			            	}
						}
					}
					if (printOut) System.out.println();
				}
				startC = startC + 3;
			}
			startC = 0;
			startR = startR + 3;
		}
		if (printOut) System.out.println("**********************************************8");
		
		// 9 horizontal lines & // 9 vertical lines
		int rr = 0;
		int cc = 0;
		for (int r = 0; r < 9; r++) {
			HashMap<Integer,Integer> vertiNine = new HashMap<>();
			HashMap<Integer,Integer> horizNine = new HashMap<>();

			for (int c = 0; c < 9; c++) {
				// going horizontal across the lines
				// System.out.print(r + "," + c + ": " + grid[r][c] + "   ");
				if (!String.valueOf(grid[r][c]).equals(".")) {
					int key = Integer.parseInt(String.valueOf(grid[r][c]));
	            	if (!horizNine.containsKey(key)) horizNine.put(key, 1);
	            	else {
	            		horizNine.put(key,horizNine.get(key) + 1);
	            		return false; // i.e. > 1 instance of any number
	            	}
				}
				// going vertical down the lines
				// System.out.print(rr + "," + cc + ": " + grid[rr][cc] + "   ");
				if (!String.valueOf(grid[rr][cc]).equals(".")) {
					int key = Integer.parseInt(String.valueOf(grid[rr][cc]));
	            	if (!vertiNine.containsKey(key)) vertiNine.put(key, 1);
	            	else {
	            		vertiNine.put(key,vertiNine.get(key) + 1);
	            		return false; // i.e. > 1 instance of any number
	            	}
				}
				rr++;
			}
			rr = 0;
			cc++;
		}
		return true;  // i.e. if not reported false so far
	}
	
	private void sLoops(char[][] grid) {
		// 3 x 3 loops (9 of)
		int startR = 0;
		int startC = 0;
		
		for (int m = 0; m < 3; m++) {
			
			for (int k = 0; k < 3; k++) {
				System.out.println(">>>>>>>>>>>> " + startR + ", " + startC);
	
				// 3 x 3 squares
				for (int i = startR; i < startR+3; i++) {
					for (int j = startC; j < startC+3; j++) {
						System.out.print(i + "," + j + ": " + grid[i][j] + "   ");
					}
					System.out.println();
				}
				startC = startC + 3;
			}
			startC = 0;
			startR = startR + 3;
		}
		System.out.println();
		System.out.println("**********************************************8");
		System.out.println();

		// 9 horizontal lines & // 9 vertical lines
		int rr = 0;
		int cc = 0;
		for (int r = 0; r < 9; r++) {	
			for (int c = 0; c < 9; c++) {
				// going horizontal across the lines
				// System.out.print(r + "," + c + ": " + grid[r][c] + "   ");
				
				// going vertical down the lines
				// System.out.print(rr + "," + cc + ": " + grid[rr][cc] + "   ");

				rr++;
			}
			rr = 0;
			cc++;
			System.out.println();
		}
	}
	
	boolean checkSingle9(char[][] grid) {
		
		int startR = 0;
		int startC = 0;
		HashMap<Integer,Integer> singleNine = new HashMap<>();
		// 3 x 3 squares
		for (int i = startR; i < startR+3; i++) {
			for (int j = startC; j < startC+3; j++) {
				if (printOut) System.out.print(i + "," + j + ": " + grid[i][j] + "   ");
				if (!String.valueOf(grid[i][j]).equals(".")) {
					int key = Integer.parseInt(String.valueOf(grid[i][j]));
					if (!singleNine.containsKey(key)) singleNine.put(key, 1);
					else {
						singleNine.put(key,singleNine.get(key) + 1);
						return false; // i.e. > 1 instance of any number
					}
				}
			}
			if (printOut) System.out.println();
		}
		return true;
		
	}

	
	private char[][] getInput() {
		
		char[][] grid = 
			{{'.','.','.','1','4','.','.','2','.'}, 
			 {'.','.','6','.','.','.','.','.','.'}, 
			 {'.','.','.','.','.','.','.','.','.'}, 
			 {'.','.','1','.','.','.','.','.','.'}, 
			 {'.','6','7','.','.','.','.','.','9'}, 
			 {'.','.','.','.','.','.','8','1','.'}, 
			 {'.','3','.','.','.','.','.','.','6'}, 
			 {'.','.','.','.','.','7','.','.','.'}, 
			 {'.','.','.','5','.','.','.','7','.'}};
		
		return grid;
	}

}
