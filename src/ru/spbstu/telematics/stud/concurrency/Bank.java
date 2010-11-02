package ru.spbstu.telematics.stud.concurrency;

public class Bank {
	private int amount = 100;
	
	synchronized boolean buy(int sum) {
		if (sum <= amount ) {
			amount-=sum;
			return true;
		}
		return false;
	}
}
