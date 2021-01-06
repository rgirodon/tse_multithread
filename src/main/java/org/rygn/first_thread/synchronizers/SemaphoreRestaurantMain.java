package org.rygn.first_thread.synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreRestaurantMain {

	public static void main(String[] args) {

		Semaphore sem = new Semaphore(5);

		ExecutorService execute = Executors.newCachedThreadPool();

		int i = 0;
		
		while (true) {
			SemaphoreClientThread cli = new SemaphoreClientThread("Client Nb" + (++i), sem);
			
			execute.execute(cli);

			try {
				Thread.sleep(100);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
