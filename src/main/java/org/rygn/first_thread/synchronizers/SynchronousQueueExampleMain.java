package org.rygn.first_thread.synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueExampleMain {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		SynchronousQueue<Integer> queue = new SynchronousQueue<>();
		
		Runnable producer = () -> {
			
			for (int i = 0; i <= 1000; i++) {
			    
			    System.out.println("Thread Producer produced : " + i);
			    
			    try {
			        queue.put(i);
			    } 
			    catch (InterruptedException ex) {
			        ex.printStackTrace();
			    }
			}
		};
		
		Runnable consumer1 = () -> {
			while(true) {
			    try {
			        Integer consumedElement = queue.take();
			        
			        System.out.println("Thread Consumer1 consumed : " + consumedElement);
			    } 
			    catch (InterruptedException ex) {
			        ex.printStackTrace();
			    }
			}
		};
		
		Runnable consumer2 = () -> {
			while(true) {
			    try {
			        Integer consumedElement = queue.take();
			        
			        System.out.println("Thread Consumer2 consumed : " + consumedElement);
			    } 
			    catch (InterruptedException ex) {
			        ex.printStackTrace();
			    }
			}
		};
		
		executor.execute(producer);
		
		executor.execute(consumer1);
		
		executor.execute(consumer2);
		 
		executor.shutdown();
	}
}
