package com.castanedadev.lambdas;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	public static void main(String[] args) {
		
		// To increment/decrement within a lambda function
		AtomicInteger aInt = new AtomicInteger(1);
		
		// Without lambda function
		OnOneListener oneListener = new OnOneListener() {
			
			@Override
			public void onOne(String msg) {
				System.out.printf("Your message #%d => %s", aInt.getAndIncrement(), msg);
				
			}
		};
		
		// Using lambda function
		OnOneListener oneListener2 = (String msg) -> {
			System.out.printf("\nYour message #%d => %s", aInt.getAndIncrement(), msg);
		};
		
		// Single line of code
		OnOneListener oneListener3 = msg -> System.out.printf("\nYour message #%d => %s", aInt.getAndIncrement(), msg);
		
		
		oneListener.onOne("Without Lambda :( ");
		oneListener2.onOne("With Lambda :D ");
		oneListener3.onOne("Single Line of Code ;)");
		

	}
}
