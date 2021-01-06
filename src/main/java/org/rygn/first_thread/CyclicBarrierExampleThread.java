package org.rygn.first_thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExampleThread implements Callable<Integer> {

	int start, end, resultat;
	
	CyclicBarrier barrier;
	
	String name;

	public CyclicBarrierExampleThread(int pStart, int pEnd, CyclicBarrier pBarrier, String pName){
      
		this.start = pStart;
      
		this.end = pEnd;
      
		this.barrier = pBarrier;
      
		this.name = pName;
   }

	public Integer call() {

		System.out.println("Le thread " + name + "  se met en action");

		int moitie = this.end - this.start / 2;

		this.resultat = 0;

		while (this.start < this.end) {

			this.resultat += this.start;
			
			this.start++;

			try {
				Thread.sleep(1);
			} 
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			if (this.start == moitie) {
				try {
					System.err.println("Le thread " + this.name + " a atteint la moiti� de sa t�che");
					
					System.err.println("\t -> " + (this.barrier.getNumberWaiting() + 1) + " threads actuellement � la barri�re !");

					this.barrier.await();

					System.out.println("Barri�re d�pass�e : Le thread " + name + " se remet � l'oeuvre !");
				} 
				catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		}

		return resultat;
	}

	public int getResultat() {
		return resultat;
	}

	public String getName() {
		return name;
	}
}
