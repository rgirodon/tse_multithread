package org.rygn.first_thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExampleMain {

	static CountDownLatch lock = new CountDownLatch(10);

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("Premier thread en attente !..");
				
				try {
					lock.await();
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Premier thread libéré  après le compte à rebours");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				
				System.out.println("Deuxième thread en attente !..");
				
				try {
					lock.await();
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Deuxième thread libéré  après le compte à rebours");
			}
		});

		CountDownLatchExampleWindow fen = new CountDownLatchExampleWindow(lock);
		t1.start();
		t2.start();
	}
}
