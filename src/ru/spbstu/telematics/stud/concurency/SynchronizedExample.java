package ru.spbstu.telematics.stud.concurency;

public class SynchronizedExample {

	//private Object someObj = new Object();

	
	private void foo() {
		//safe operations
		//...
		dangerous();
		//etc
		
	}

	private synchronized void dangerous() {
		//dangerous operations
	}
	
}
