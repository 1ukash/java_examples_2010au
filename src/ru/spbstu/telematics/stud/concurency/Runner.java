package ru.spbstu.telematics.stud.concurency;

public class Runner {
	public static void main(String[] args) throws Exception {
		SimpleTimer t = new SimpleTimer();
		
		Thread timer = new Thread(t, "timer thread");
		
		timer.start();
		
		Thread.sleep(10000);
		timer.interrupt();
		
	}
}
