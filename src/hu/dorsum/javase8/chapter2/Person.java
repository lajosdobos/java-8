package hu.dorsum.javase8.chapter2;

import java.util.Set;

public class Person {

	private String firstName;
	private String lastName;
	private int age;
	private Set<String> favouriteBooks;
	
	public Person(){}
	
	public Person(String firstName, String lastName, int age, Set<String> books) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.favouriteBooks = books;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<String> getBooks() {
		return favouriteBooks;
	}

	public void setBooks(Set<String> books) {
		this.favouriteBooks = books;
	}

	@Override
	public String toString() {
		return lastName + " " + firstName + ", age:" + age;
	}
	
	public void printPerson() {
		System.out.println(lastName + " " + firstName + ", age:" + age);
	}
	
	public static void printSomething() {
		System.out.println("sthgs");
	}
	
}
