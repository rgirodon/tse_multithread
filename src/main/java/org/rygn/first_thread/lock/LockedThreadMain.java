package org.rygn.first_thread.lock;

public class LockedThreadMain {

	public static LockedIncrement increment = new LockedIncrement();
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new LockedThread());
		Thread t2 = new Thread(new LockedThread());
		Thread t3 = new Thread(new LockedThread());
		Thread t4 = new Thread(new LockedThread());
	  
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
