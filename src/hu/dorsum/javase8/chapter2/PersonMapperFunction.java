package hu.dorsum.javase8.chapter2;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class PersonMapperFunction implements Function<String, Person>{

	@Override
	public Person apply(String line) {
		String[] tmp = line.split(",");
		String firstName = null;
		String lastName = null;
		Set<String> books = new HashSet<>();
		Integer age = 0;
		try {
			lastName = tmp[0].split(" ")[0];
			firstName = tmp[0].split(" ")[1];
			age = Integer.parseInt(tmp[1].trim());

			for(int i=2; i<tmp.length;i++){
				books.add(tmp[i]);
			}
		} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.err.println("Hiba: " + e);
			return null;
		}
		
		return new Person(firstName, lastName, age, books);
	}

}
