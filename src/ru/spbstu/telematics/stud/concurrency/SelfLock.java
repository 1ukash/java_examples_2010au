package ru.spbstu.telematics.stud.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class SelfLock {
	static Object o = new Object();
	static ReentrantLock l = new ReentrantLock();

	public static void main(String[] args) {
		synchronized (o) {
			System.out.println("yep");
			synchronized (o) {
				System.out.println("yep-yep");
			}
		}
	}
}
