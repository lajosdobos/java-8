package hu.dorsum.javase8.chapter1;

public class Car implements IVehicle {
	
	@Override
	public String toString() {
		return "Car [ numberOfWheels: " + IVehicle.super.getNumberOfWheels() +  " ]";
	}
	
}
