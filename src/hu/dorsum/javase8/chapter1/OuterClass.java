package hu.dorsum.javase8.chapter1;

public class OuterClass {
	
	class InnerClass {
		void print() {
			System.out.println("Print from inner class");
		}
	}
	
	void print() {
		System.out.println("Print from outer class");
		InnerClass ic = new InnerClass();
		ic.print();
	}
	
	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		oc.print();
	}
	
}

