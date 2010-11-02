package ru.spbstu.telematics.stud.concurrency;

import java.util.Random;

public class StackRunner {
	
	public static void main(String[] args) {
		final BlockingStack<Integer> stack = new BlockingStack<Integer>(5);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while (!Thread.currentThread().isInterrupted()) {
					int val = new Random().nextInt();
					try {
						stack.put(val);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("put val = " + val);
					try {
						Thread.sleep(Math.abs(new Random().nextInt()%200));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while (!Thread.currentThread().isInterrupted()) {
					try {
						int val = stack.take();
						System.out.println("take val = " + val);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						Thread.sleep(Math.abs(new Random().nextInt()%2000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		}).start();
		
	}

}
