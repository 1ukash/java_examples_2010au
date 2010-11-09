package ru.spbstu.telematics.stud.concurrency.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class FutureExample {
	
	static ExecutorService service = Executors.newFixedThreadPool(4);
	static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println("first ");
		
		Future<String> future = service.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "async task";
			}
			
		});
		
		System.out.println("second ");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("third ");
		
		if (future.isDone()) {
			System.out.println("Future ready");
		} else {
			System.out.println("Future NOT ready");
		}
		
		String res = future.get();
		System.out.println(res);
		
		if (future.isDone()) {
			System.out.println("Future ready");
		}
		
		//scheduledThreadPool.schedule(callable, delay, unit)
		service.shutdown();
	}
	
	

}
