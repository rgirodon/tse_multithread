package org.rygn.first_thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerExampleFileFinder implements Runnable {

	private List<String> listDocument = new ArrayList<>();

	private List<String> listDocumentInitial = new ArrayList<>();

	Exchanger<List<String>> exchanger;

	public ExchangerExampleFileFinder(Exchanger<List<String>> ex) {

		exchanger = ex;

		listDocumentInitial.add("fichier 1");

		listDocumentInitial.add("fichier 2");

		listDocumentInitial.add("fichier 3");

		listDocumentInitial.add("fichier 4");

		listDocumentInitial.add("fichier 5");
	}

	@Override
	public void run() {
		
		int numEchange = 1;
		
		while (true) {

			System.out.println("---------------------------------------");
			
			System.out.println("Contenu de la liste côté Finder : ");
			
			System.out.println(listDocument);
			
			System.out.println("---------------------------------------");
			
			Iterator<String> it = listDocumentInitial.iterator();

			while (it.hasNext()) {
				
				String nom = numEchange + "-" + it.next();
				
				listDocument.add(nom);
				
				System.out.println("[+] Ajout de " + nom + " dans la collection");
				
				try {
					Thread.sleep(2500);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				System.err.println("\t -> Liste remplie côté Finder !");
				
				listDocument = exchanger.exchange(listDocument);
				
				numEchange++;
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
