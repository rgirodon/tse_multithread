package org.rygn.first_thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskMain {

	public static void main(String[] args) {

		Callable<Integer> c1 = new Callable<Integer>() {
			
			public Integer call() throws Exception {
				
				Random rand = new Random();
				
				int result = rand.nextInt(2_000);
				
				System.out.println("Dans l'objet Callable : " + result);
				
				try {
					Thread.sleep(3_000);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}

				return result;
			}
		};

		FutureTask<Integer> ft1 = new FutureTask<>(c1);

		System.out.println(" - Lancement de notre premier test.");

		Thread t = new Thread(ft1);

		t.start();
		
		System.out.println("Traitement…");
		
		try {
			System.out.println("Résultat : " + ft1.get());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		showStatus(ft1);

		System.out.println("\n - Lancement de notre second test.");
		
		ft1 = new FutureTask<>(c1);
		
		t = new Thread(ft1);
		
		t.start();
		
		System.out.println("Traitement…");

		try {
			System.out.println("Résultat : " + ft1.get(500, TimeUnit.MILLISECONDS));
		} 
		catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.err.println("La tâche à mis trop de temps à répondre.");
		}

		showStatus(ft1);
	}

	private static void showStatus(FutureTask<Integer> ft1) {
		if (ft1.isDone())
			System.out.println("La tâche c'est déroulée correctement");

		if (ft1.isCancelled())
			System.out.println("La tâche a été annulée");
	}

}
