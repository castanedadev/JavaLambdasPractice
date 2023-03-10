package com.castanedadev.lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
	public static void main(String[] args) {
		UnaryOperator<String> quote = text -> "\"" + text + "\"";
		System.out.println(quote.apply("Hello!"));
		
		// Takes more than one parameter
		BiFunction<Integer, Integer, Integer> multiply = new BiFunction<Integer, Integer, Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t*u;
			}
		
		};
		
		System.out.println(multiply.apply(2, 3));
		
		// If data type is common for both params
		BinaryOperator<Integer> multiplySameType = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t * u;
			}
		};
		
		System.out.println(multiplySameType.apply(2, 4));
		
		BiFunction<String, Integer, String> leftPad = (text, number) -> String.format("%" + number + "s", text);
		System.out.println(leftPad.apply("Hello", 5));
	}
}
