package org.rygn.first_thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreClientThread implements Runnable {

	String name;
	Semaphore sem;

	public SemaphoreClientThread(String pName, Semaphore pSem){
      this.name = pName;
      this.sem = pSem;
   }

	public void run() {
		try {
			this.sem.acquire();

			Random rand = new Random();

			long pause = 0;
			while (pause < 8000)
				pause = rand.nextInt(15000);

			System.out.println(this.name + " : Je mange au restaurant pendant " + pause / 1000 + " secondes");

			Thread.sleep(pause);

			System.err.println(this.name + " : Au revoir. Je quitte le restaurant. ");

			this.sem.release();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
