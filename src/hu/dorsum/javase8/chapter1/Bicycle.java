package hu.dorsum.javase8.chapter1;

public class Bicycle implements IVehicle {

	@Override
	public int getNumberOfWheels() {
		return 2;
	}
	
	@Override
	public String toString() {
		return "Bicycle [ numberOfWheels: " + getNumberOfWheels() + " ]";
	}
	
}
