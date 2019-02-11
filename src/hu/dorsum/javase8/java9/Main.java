package hu.dorsum.javase8.java9;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	
	public static void main(String[] args) {
		
		//new methods for creating collections
		List<String> immutableList = createImmutableList();
		immutableList.forEach(System.out::println);
		
		List<String> immutableList2 = createList();
		immutableList2.forEach(System.out::println);
		
		
		//new features for stream and optional
		final String takeTheFirstFewValues = IntStream.range(0, 10)
				.takeWhile(i -> i < 5)
				.mapToObj(String::valueOf)			//.mapToObj(i -> String.valueOf(i))				
				.collect(Collectors.joining(","));
		System.out.println(takeTheFirstFewValues); // 0,1,2,3,4

		final String dropTheFirstFewValues = IntStream.range(0, 10)
				.dropWhile(i -> i < 5)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(","));
		System.out.println(dropTheFirstFewValues); // 5,6,7,8,9
		
	}

	private static List<String> createImmutableList() {
		final String a = "abc";
		final String b = "def";
		final String c = "ghi";
		
		return Collections.unmodifiableList(Arrays.asList(a, b, c));
	}
	
	private static Set<String> createImmutableSet() {
		final String a = "abc";
		final String b = "def";
		final String c = "ghi";

		return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(a, b, c)));
	}
	
	private static List<String> createList() {
		final String a = "abc2";
		final String b = "def2";
		final String c = "ghi2";
		
		return List.of(a, b, c);
	}
	
	private static Set<String> createSet() {
		final String a = "abc2";
		final String b = "def2";
		final String c = "ghi2";
		
		return Set.of(a, b, c);
	}

	public void createImmutableCollections() {
		final String a = "abc";
		final String b = "def";
		final String c = "ghi";

		final List<String> immutableList = List.of(a, b, c);

		final Set<String> immutableSet = Set.of(a, b, c);

		final Map<Integer, String> immutableMap = Map.of(1, a, 2, b, 3, c);
		// VAGY
		final Map<Integer, String> immutableMapFromEntries = Map.ofEntries(Map.entry(1, a), Map.entry(2, b), Map.entry(3, c));
	}
	
	
}
