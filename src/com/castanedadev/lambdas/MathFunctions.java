package com.castanedadev.lambdas;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
	public static void main(String[] args) {
		Function<Integer, Integer> square = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t * t;
			}
		};
		
		System.out.println(square.apply(5));
		
		// Improve readability
		Function<Integer, Boolean> isOdd = x -> x%2 == 1;
		
		// Predicate works using a given type then returns a Boolean
		Predicate<Integer> isEven = x -> x % 2 == 0;
		isEven.test(4);
		
		Predicate<Student> isApproved = student -> student.getGrade() >= 6.0;
		Student rick = new Student(5.9);
		Student morty = new Student(6.1);
		System.out.println(isApproved.test(rick));
		System.out.println(isApproved.test(morty));

	}
	
	static class Student {
		private double grade;
		
		public Student(double grade) {
			this.grade = grade;
		}
		
		public double getGrade() {
			return grade;
		}

		public void setGrade(double grade) {
			this.grade = grade;
		}
		
	}
}
