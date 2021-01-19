package org.rygn.first_thread.synchronizers;

import java.util.concurrent.Phaser;

public class PhaserExampleRunnable implements Runnable {

	private String threadName;
	
    private Phaser ph;
	
    public PhaserExampleRunnable(String threadName, Phaser ph) {
		
    	this.threadName = threadName;
    	
        this.ph = ph;
        
        ph.register();
        
        System.out.println("Thread " + threadName + " has registered to phase " + ph.getPhase());
	}
    
	@Override
	public void run() {
		
        System.out.println("Thread " + threadName + " before long running action");
		
		// do fake job
		try {
            Thread.sleep(20);
        } 
		catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		System.out.println("Thread " + threadName + " has completed running action");
		
		ph.arriveAndAwaitAdvance();
		
		System.out.println("Thread " + threadName + " deregisters");
		
		ph.arriveAndDeregister();
	}

}
