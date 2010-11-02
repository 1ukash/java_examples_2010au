package ru.spbstu.telematics.stud.concurrency;

public class Monitor {
	private int a;
	private int b;

	public synchronized int getA() {
		return a;
	}

	public synchronized void setA(int a) {
		this.a = a;
	}

	public synchronized int getB() {
		return b;
	}

	public synchronized void setB(int b) {
		this.b = b;
	}
}
