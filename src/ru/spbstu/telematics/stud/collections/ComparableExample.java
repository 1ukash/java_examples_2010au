package ru.spbstu.telematics.stud.collections;

public class ComparableExample {
	
	private interface Comparable<T> {
		int compareTo(T other);
	}
	
	public static <T extends Comparable<? super T>> T min(T[] a) {
		return null;
	}
	
	public class A implements Comparable<A>{

		@Override
		public int compareTo(A other) {
			return 0;
		}
		
	}
	
	public class B extends A {
		
	}
	
	public class C {
		
	}
	
	private void foo() {
		B b = min(new B[10]);
		A a = min(new A[10]);
		//C c = min(new C[10]);
	}

}
