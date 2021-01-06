package org.rygn.first_thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThreadMain {

	public static AtomicInteger entier = new AtomicInteger(0);
	
	public static void main(String[] args) {
		
		Thread at1 = new Thread(new AtomicThread(), "at1");
		Thread at2 = new Thread(new AtomicThread(), "at2");
		Thread at3 = new Thread(new AtomicThread(), "at3");
		Thread at4 = new Thread(new AtomicThread(), "at4");
	  
		at1.start();
		at2.start();
		at3.start();
		at4.start();
	}

}
