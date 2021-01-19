package org.rygn.first_thread.synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExampleMain {

	public static void main(String[] args) {
		
		String threadName = Thread.currentThread().getName();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Phaser ph = new Phaser();
		
		ph.register();
		
		System.out.println("Thread " + threadName + " has registered to phase " + ph.getPhase());

		executorService.submit(new PhaserExampleRunnable("thread-1", ph));
		
		executorService.submit(new PhaserExampleRunnable("thread-2", ph));
		
		executorService.submit(new PhaserExampleRunnable("thread-3", ph));
		
		System.out.println("Thread " + threadName + " has completed 1st running action");
		
		ph.arriveAndAwaitAdvance();
		
		System.out.println("This is phase " + ph.getPhase() + " for Thread " + threadName);
		
		executorService.submit(new PhaserExampleRunnable("thread-4", ph));
		
		executorService.submit(new PhaserExampleRunnable("thread-5", ph));
		
		System.out.println("Thread " + threadName + " has completed 2nd running action");
		
		ph.arriveAndAwaitAdvance();
		
		System.out.println("Thread " + threadName + " deregisters");
		 
		ph.arriveAndDeregister();
		
		executorService.shutdown();
	}
}
