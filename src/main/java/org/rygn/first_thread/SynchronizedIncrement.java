package org.rygn.first_thread;

public class SynchronizedIncrement {

	private Integer entier = 0;

	public Integer incrementAndGet() {
		synchronized (this) {
			this.entier++;
			return this.entier;
		}
	}

}
