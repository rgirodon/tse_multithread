package org.rygn.first_thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThreadMain {

	public static AtomicInteger entier = new AtomicInteger(0);
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new AtomicThread());
		Thread t2 = new Thread(new AtomicThread());
		Thread t3 = new Thread(new AtomicThread());
		Thread t4 = new Thread(new AtomicThread());
	  
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
