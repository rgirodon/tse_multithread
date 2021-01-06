package org.rygn.first_thread.lock;

import java.util.Random;

public class BankDepotThread extends Thread {

	private BankAccount ceb;

	private Random rand = new Random();

	public BankDepotThread(BankAccount c) {

		this.ceb = c;

		this.setName("Dépôt");
	}

	public void run() {
		
		while (true) {
			int nb = rand.nextInt(100);
			
			long montant = Integer.valueOf(nb).longValue();
			
			ceb.depot(montant);
			
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
			}
		}
	}
}
