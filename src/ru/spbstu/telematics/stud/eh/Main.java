package ru.spbstu.telematics.stud.eh;

public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		EqualsExample e1 = new EqualsExample(1, "a");
		EqualsExample e2 = e1.copy();
		
		if (e1.equals(e2)) {
			System.out.println("e1 equals e2");
		}
		
		
	}
}
