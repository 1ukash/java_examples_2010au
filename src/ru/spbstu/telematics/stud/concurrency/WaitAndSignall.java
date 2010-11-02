package ru.spbstu.telematics.stud.concurrency;

public class WaitAndSignall implements Runnable {

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			//do smth
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//do an0ther
			notify();
			notifyAll();
			
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
