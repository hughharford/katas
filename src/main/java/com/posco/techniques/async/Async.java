package com.posco.techniques.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.LongStream;

public class Async {

	public static void main(String[] args) {
		Async synco = new Async();
		
		int maxTwenty = 20;
		
		synco.runFutureTask(maxTwenty);
		synco.runThreadTask(maxTwenty);
		
	}
	
	private void runThreadTask(int number) {
		
		// up to 20
		Thread newThread = new Thread(() -> {
		    System.out.println("runThreadTask: Factorial of " + number + " is: " + factorialUsingStreams(number));
		});
		newThread.start();
		
	}
	
	public long factorialUsingStreams(int n) {
	    return LongStream.rangeClosed(1, n)
	        .reduce(1, (long x, long y) -> x * y);
	}

	private void runFutureTask(int n) {
		ExecutorService threadpool = Executors.newCachedThreadPool();
		Future<Long> futureTask = threadpool.submit(() -> factorialUsingStreams(n));

		while (!futureTask.isDone()) {
		    System.out.println("FutureTask is not finished yet..."); 
		} 
		try {
			long result = futureTask.get();
			System.out.println("runFutureTask: result = " + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		threadpool.shutdown();
	}
	
}
