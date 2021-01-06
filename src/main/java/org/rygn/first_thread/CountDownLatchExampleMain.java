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
				
				System.out.println("Premier thread lib�r�  apr�s le compte � rebours");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				
				System.out.println("Deuxi�me thread en attente !..");
				
				try {
					lock.await();
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Deuxi�me thread lib�r�  apr�s le compte � rebours");
			}
		});

		CountDownLatchExampleWindow fen = new CountDownLatchExampleWindow(lock);
		t1.start();
		t2.start();
	}
}
