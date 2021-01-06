package org.rygn.first_thread.synch;

public class SynchronizedIncrement {

	private Integer entier = 0;

	/*
	public Integer incrementAndGet() {
	
		synchronized (this) {
			
			this.entier++;
			
			return this.entier;
		}
	}
	*/
	
	public synchronized Integer incrementAndGet() {
		
		this.entier++;
		
		return this.entier;
	}
}
