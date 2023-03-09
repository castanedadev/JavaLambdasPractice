package com.castanedadev.lambdas;

import java.util.Arrays;
import java.util.List;

public class StreamsAndFilters {
	public static void main(String[] args) {
		List<String> strawHatPirates = Arrays.asList("Luffy", "Zoro", "Nami", "Usopp", "Sanji", "Robin", "", null);
		strawHatPirates.stream().filter(member -> member != null).filter(member -> member != "")
				.forEach(System.out::println);
	}
}
