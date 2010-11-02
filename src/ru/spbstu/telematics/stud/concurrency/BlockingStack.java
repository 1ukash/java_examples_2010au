package ru.spbstu.telematics.stud.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingStack <T> {
	private Object[] array;
	private int curr;
	private ReentrantLock readlock = new ReentrantLock();
	private ReentrantLock writelock = new ReentrantLock();
	private Condition readcond = readlock.newCondition();
	private Condition writecond = writelock.newCondition();
	
	public BlockingStack(int size) {
		array = new Object[size];		
		curr = -1;
	}
	
	
	public void put (T o) throws InterruptedException {
		
		if (curr + 1 < array.length) {
			
			array[curr+1] = o;
			curr++;
			writelock.lock();
			try {
				writecond.signal();
			} finally {
				writelock.unlock();
			}
			
		} else {
			readlock.lock();
			try {
				readcond.await();
			} finally {
				readlock.unlock();
			}
		}
		
	}
	
	public T take () throws InterruptedException {
		
		if (curr < 0 ) {
			writelock.lock();
			try {
				writecond.await();
			} finally {
				writelock.unlock();
			}
		}
		T tmp = (T) array[curr];
		array[curr] = null;
		curr--;
		readlock.lock();
		try {
			readcond.signal();
		} finally {
			readlock.unlock();
		}
		return tmp;
	}

}
