package org.rygn.first_thread.lock;

public class BankThreadMain {

	public static void main(String[] args) {
		
		BankAccount ceb = new BankAccount();

		Thread t1 = new BankRetraitThread(ceb);
		t1.start();

		Thread t2 = new BankRetraitThread(ceb);
		t2.start();

		Thread t3 = new BankDepotThread(ceb);
		t3.start();
	}
}
