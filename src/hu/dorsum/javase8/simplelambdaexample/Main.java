package hu.dorsum.javase8.simplelambdaexample;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private static int x = 10;
	private static int y = 5;

	static double calc(CalculatorInterface calculator) {
		return calculator.calculate(x, y * calculator.getRandomNumber());		
	}	
	
	public static void main(String[] args) {
		//lambda expression
		System.out.println(calc((x, y) -> x + y));
		System.out.println(calc((x, y) -> x * y));
		System.out.println(calc((int x, double y) -> x - y));
		System.out.println(calc((x, y) -> {
			return x / y;	
		}));
		
		//implementing interface
//		Calculator c = new Calculator();
//		System.out.println(c.calculate(x, y));
		
		List<Integer> list = new LinkedList<>();
		list.add(5); 
		list.add(2);		
		
		List<Integer> result = list.stream()
				.sorted()
				.collect(Collectors.toList());
		result.forEach(l -> System.out.println("element no. " + l));			
		list.forEach((l) -> System.out.println("element no. " + l));		
			
	}

}
