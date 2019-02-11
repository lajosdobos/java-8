package hu.dorsum.javase8.chapter1;

import hu.dorsum.javase8.chapter2.Person;

public interface IVehicle {

	public int NUMBER_OF_WHEELS = 4;
	
	default int getNumberOfWheels() {
		return NUMBER_OF_WHEELS;
	}
		
	default void print(Person owner) {
		if(!isNull(owner)) {
			System.out.println("Owner: " + owner.toString() + ", Vehicle: " + this.toString());
		} 
	}
	
	static boolean isNull(Person owner) {
		return owner == null;
	}
	
}
