package com.castanedadev.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class StreamsAndFilters {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		AtomicInteger aInt = new AtomicInteger(1);
		List<String> strawHatPirates = Arrays.asList("Luffy", "Zoro", "Nami", "Usopp", "Sanji", "Robin", "Jinbei", "", null);

		HttpResponse<JsonNode> response = Unirest.get("https://animechan.vercel.app/api/quotes/anime?title=One Piece")
				.asJson();
		
		// Print all quotes from One Piece
		response.getBody().getArray().forEach(quote -> System.out.printf("\n#%d %s", aInt.getAndIncrement(), quote));

		// Print only character field from each one piece quote object
		response.getBody().getArray().forEach(quote -> System.out.println(((JSONObject) quote).get("character")));

		// Print all quotes from straw hat pirates members only
		Predicate<JSONObject> isStrawHatPirate = quote -> strawHatPirates.contains(quote.get("character"));
		response.getBody().getArray().toList().stream().filter(isStrawHatPirate).forEach(System.out::println);
	}
}
