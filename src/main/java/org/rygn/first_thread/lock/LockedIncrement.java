package org.rygn.first_thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedIncrement {

	private Integer entier = 0;
	
	private Lock lock = new ReentrantLock();
	
	public Integer incrementAndGet() {
		
		lock.lock();
		
		try {		
			this.entier++;
			
			return this.entier;
		}
		finally {
			lock.unlock();
		}
	}
}
