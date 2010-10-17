package ru.spbstu.telematics.stud;

public class Foo {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Bar bar = new Bar("abc");
		bar.foo();
		Baz baz = new Baz("c");
		baz.foo();
		Bar barbaz = new Baz("y");
		barbaz.foo();
		
		if (bar instanceof Bar) {
			System.out.println("Bar!");
		}
		if (baz instanceof Bar) {
			System.out.println("Baz is Bar!");
		}
		if (bar instanceof Baz) {
			System.out.println("Bar is Baz!");
		}
		
		Class clazz = bar.getClass();
		Class bazClazz = Baz.class;
		if (clazz == bazClazz) {
			System.out.println("!baz is bar");
		}
		
	}
}
