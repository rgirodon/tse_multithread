package org.rygn.first_thread;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

	private AtomicLong solde = new AtomicLong(1000L);

	private AtomicLong tentativeDeRetrait = new AtomicLong(0);

	private final long decouvert = -130L;

	private Lock verrou = new ReentrantLock();

	private Condition condition = verrou.newCondition();

	public void retrait(long montant) {

		this.verrou.lock();

		String threadName = Thread.currentThread().getName();

		try {
			while ((this.solde.get() - montant) < this.decouvert) {

				System.err.println(threadName + " tente de retirer " + montant);

				this.tentativeDeRetrait.addAndGet(montant);

				condition.await();
			}

			this.solde.set((this.solde.get() - montant));

			this.printSolde();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.verrou.unlock();
		}
	}

	public void depot(long montant) {

		this.verrou.lock();

		try {
			long result = this.solde.addAndGet(montant);
			
			this.printSolde();

			long soldeApresRetrait = this.getSolde() - this.tentativeDeRetrait.get();

			if (soldeApresRetrait > this.decouvert) {

				this.tentativeDeRetrait.set(0);

				this.condition.signalAll();
				
				System.err.println("\n Montant après retrait (" + soldeApresRetrait + ") < découvert \n");
			}

		} 
		finally {
			this.verrou.unlock();
		}
	}

	public void printSolde() {

		System.out.println("Solde actuel, dans " + Thread.currentThread().getName() + " : " + this.solde.longValue());
	}

	public long getSolde() {

		return this.solde.longValue();
	}

	public long getDecouvert() {

		return this.decouvert;
	}
}
