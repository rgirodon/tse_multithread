package org.rygn.first_thread;

public class SynchronizedThreadMain {

	public static SynchronizedIncrement increment = new SynchronizedIncrement();
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new SynchronizedThread());
		Thread t2 = new Thread(new SynchronizedThread());
		Thread t3 = new Thread(new SynchronizedThread());
		Thread t4 = new Thread(new SynchronizedThread());
	  
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
