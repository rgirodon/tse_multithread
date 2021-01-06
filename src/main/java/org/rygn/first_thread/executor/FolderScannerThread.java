package org.rygn.first_thread.executor;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FolderScannerThread implements Callable<Long> {

	private Path path = null;
	
	private long result = 0;

	public FolderScannerThread(){ }

	public FolderScannerThread(Path pf){
	    this.path = pf;
	}


	public Long call() {

		System.out.println("Exécution dans " + Thread.currentThread().getName());
		
		System.out.println("Scan du dossier : " + this.path + " à la recherche des fichiers ");

		try (DirectoryStream<Path> listing = Files.newDirectoryStream(path)) {
			
			for (Path nom : listing) {
				
				if (Files.isDirectory(nom.toAbsolutePath())) {

					FolderScannerThread f = new FolderScannerThread(nom.toAbsolutePath());

					FutureTask<Long> ft = new FutureTask<>(f);
					
					Thread t = new Thread(ft);
					
					t.start();
					
					try {
						result += ft.get();
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					} 
					catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		try (DirectoryStream<Path> listing = Files.newDirectoryStream(path)) {
			
			for (Path nom : listing) {
				
				result++;
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
