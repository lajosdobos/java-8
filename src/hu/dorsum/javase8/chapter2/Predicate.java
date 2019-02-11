package hu.dorsum.javase8.chapter2;

@FunctionalInterface
public interface Predicate<T> {
	public boolean test(T t);	
}
