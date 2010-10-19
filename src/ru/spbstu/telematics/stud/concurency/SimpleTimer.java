package ru.spbstu.telematics.stud.concurency;

import java.util.Date;

public class SimpleTimer implements Runnable {

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println(new Date(System.currentTimeMillis()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
}
