package ru.spbstu.telematics.stud.reflections;

public class Foo {
	private Integer a;
	private String b;

	public Foo() {
	}

	public Foo(Integer a, String b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
	
	private void secretMethod() {
		
	}

}
