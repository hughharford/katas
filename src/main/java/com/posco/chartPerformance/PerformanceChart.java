package com.posco.chartPerformance;

import edu.princeton.cs.algs4.StdDraw;

public class PerformanceChart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PerformanceChart c1 = new PerformanceChart();
		c1.readyOutput();
		c1.readyChart();
	}
	
	private void readyChart() {
		
		// x-Axis line
		
		// y-Axis line
		
		
	}
	
	private void readyOutput() {
		// ready to draw 
		StdDraw.enableDoubleBuffering();
		// StdDraw.setXscale(-300, 300);   // -32768, 32768

		// StdDraw.setYscale(-300, 300);
		StdDraw.setPenRadius(0.005); 
		
		// Posco blue
		int red = 49;
		int green = 43;
		int blue = 128;
		StdDraw.setPenColor(red, green, blue);
		
	}
	
}
