package hu.dorsum.javase8.simplelambdaexample;

import java.util.function.Consumer;

import hu.dorsum.javase8.chapter2.Person;

public class PersonPrinter implements Consumer<Person> {

	@Override
	public void accept(Person t) {
		System.out.println(t);
	}

}
