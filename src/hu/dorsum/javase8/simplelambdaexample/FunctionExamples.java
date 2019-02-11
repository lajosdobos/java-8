package hu.dorsum.javase8.simplelambdaexample;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExamples {

	private static int number = 10;
	
	public static void main(String[] args) {
		
		//Predicate example		
		boolean result = getResult(number, i -> i > 5);
		System.out.println("Result: " + result);
		
		//Consumer example
		print("testString", s -> System.out.println(s));
		
		//Function example
		String parsedInteger = parse(10, i -> String.valueOf(i));
		System.out.println(parsedInteger);
	}
	
	static boolean getResult(int i, Predicate<Integer> predicate) {
		return predicate.test(i);
	}
	
	static void print(String s, Consumer<String> consumer) {
		consumer.accept(s);
	}
	
	static int compare(int x, int y, Comparator<Integer> comparator) {
		return comparator.compare(x, y);
	}
	
	static String parse(Integer i, Function<Integer, String> function) {
		return function.apply(i);
	}
}
