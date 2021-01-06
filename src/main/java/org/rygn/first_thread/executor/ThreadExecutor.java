package org.rygn.first_thread.executor;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExecutor {

	public static void main(String[] args) {

		// ExecutorService execute = Executors.newSingleThreadExecutor();
		// ExecutorService execute = Executors.newCachedThreadPool();
		ExecutorService execute = Executors.newFixedThreadPool(2);
		
		Path chemin1 = Paths.get("/var/www/html/wordpress");
		Path chemin2 = Paths.get("/home/rgirodon/repositories");
		Path chemin3 = Paths.get("/home/rgirodon/telecomSaintEtienne");

		Future<Long> ft1 = execute.submit(new FolderScannerThread(chemin1));
		Future<Long> ft2 = execute.submit(new FolderScannerThread(chemin2));
		Future<Long> ft3 = execute.submit(new FolderScannerThread(chemin3));

		Long total;
		try {
			total = ft1.get() + ft2.get() + ft3.get();

			System.out.println("Nombre total de fichiers trouvés : " + total);
		} 
		catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		execute.shutdown();
	}
}
