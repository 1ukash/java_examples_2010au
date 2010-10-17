package ru.spbstu.telematics.stud;

public class Baz extends Bar {

	public Baz(String string) {
		super(string);
	}
	
	@Override
	public void foo() {
		System.out.println("I'm Baz");
	}

}
