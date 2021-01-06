package org.rygn.first_thread;

import java.util.Random;

public class BankRetraitThread extends Thread {

	private static int NB_THREAD = 1;

	private BankAccount ceb;

	private Random rand = new Random();

	public BankRetraitThread(BankAccount c) {

		this.ceb = c;

		this.setName("Retrait  " + NB_THREAD++);
	}

	public void run() {
		
		while (true) {
			int nb = rand.nextInt(300);
			
			long montant = Integer.valueOf(nb).longValue();
			
			ceb.retrait(montant);

			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
			}
		}
	}
}
