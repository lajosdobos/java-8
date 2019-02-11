package hu.dorsum.javase8.simplelambdaexample;

@FunctionalInterface
public interface CalculatorInterface {
	double calculate(int x, double y);
	
	default double getRandomNumber() {
		return Math.random();
	}
}
