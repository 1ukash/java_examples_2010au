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
	private ReentrantLock lock = new ReentrantLock();
	
	public BlockingStack(int size) {
		array = new Object[size];		
		curr = -1;
	}
	
	
	public void put (T o) throws InterruptedException {
		boolean canPut = false;
		lock.lock();
		try {
			canPut = curr + 1 < array.length;
			if (canPut) {
				array[curr+1] = o;
				curr++;
				writelock.lock();
				try {
					writecond.signal();
				} finally {
					writelock.unlock();
				}
			} 
		} finally {
			lock.unlock();
		}
		
		if (!canPut) {
			readlock.lock();
			try {
				readcond.await();
			} finally {
				readlock.unlock();
			}
		}
		
	}
	
	public T take () throws InterruptedException {
		boolean canTake = false;

		lock.lock();
		try {
			canTake = curr >= 0;
		}
		finally {
			lock.unlock();
		}

		if (!canTake) {
			writelock.lock();
			try {
				writecond.await();
			} finally {
				writelock.unlock();
			}
		}
		
		T tmp = null;
		lock.lock();
		try {
			tmp = (T) array[curr];
			array[curr] = null;
			curr--;
			readlock.lock();
			try {
				readcond.signal();
			} finally {
				readlock.unlock();
			}
		} finally {
			lock.unlock();
		}
		return tmp;
	}

}
