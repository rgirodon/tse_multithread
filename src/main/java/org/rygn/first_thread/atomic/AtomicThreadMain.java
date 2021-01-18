package org.rygn.first_thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThreadMain {

	public static AtomicInteger entier = new AtomicInteger(0);
	
	public static void main(String[] args) {
		
		Thread at1 = new Thread(new AtomicThread(), "at1");
		Thread at2 = new Thread(new AtomicThread(), "at2");
		Thread at3 = new Thread(new AtomicThread(), "at3");
		Thread at4 = new Thread(new AtomicThread(), "at4");
		Thread at5 = new Thread(new AtomicThread(), "at5");
		Thread at6 = new Thread(new AtomicThread(), "at6");
		Thread at7 = new Thread(new AtomicThread(), "at7");
		Thread at8 = new Thread(new AtomicThread(), "at8");
	  
		at1.start();
		at2.start();
		at3.start();
		at4.start();
		at5.start();
		at6.start();
		at7.start();
		at8.start();
	}

}
