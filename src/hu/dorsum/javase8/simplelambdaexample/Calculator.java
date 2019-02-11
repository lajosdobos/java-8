package hu.dorsum.javase8.simplelambdaexample;

public class Calculator implements CalculatorInterface {

	@Override
	public double calculate(int x, double y) {
		return x * y * getRandomNumber();
	}

}
