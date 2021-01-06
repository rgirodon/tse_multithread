package org.rygn.first_thread.synchronizers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerExampleFileMover implements Runnable {

	private List<String> listDocument = new ArrayList<>();

	Exchanger<List<String>> exchanger;

	public ExchangerExampleFileMover(Exchanger<List<String>> ex) {

		exchanger = ex;
	}

	@Override
	public void run() {

		while (true) {

			System.out.println("---------------------------------------");
			
			System.out.println("Contenu de la liste côté Mover : ");
			
			System.out.println(listDocument);
			
			System.out.println("---------------------------------------");
			
			Iterator<String> it = listDocument.iterator();

			while (it.hasNext()) {
				
				String nom = it.next();

				it.remove();

				System.out.println("[-] Suppression de " + nom + " dans la collection");
				
				try {
					Thread.sleep(1500);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				System.err.println("\t -> Liste vide du côté Mover !");
				
				listDocument = exchanger.exchange(listDocument);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
