package hu.dorsum.javase8.chapter1;

import hu.dorsum.javase8.chapter2.Person;

public class Main {

	public static void main(String[] args) {		
		//Interface default methods
		IVehicle audi = new Car();
		IVehicle csepel = new Bicycle();
		Person person = new Person("Arpad", "Zambo", 20, null);
				
		System.out.println("Interface default methods:");
		System.out.println(audi.getNumberOfWheels());
		System.out.println(csepel.getNumberOfWheels());				
		
		System.out.println("------------------");
		csepel.print(null);
		csepel.print(person);

	}
}
