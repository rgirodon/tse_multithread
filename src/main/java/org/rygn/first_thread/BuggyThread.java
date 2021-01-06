package org.rygn.first_thread;

public class BuggyThread implements Runnable {

	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
	         
			System.out.println(Thread.currentThread().getName() + " - " + ++(BuggyThreadMain.entier));         
	        
			try {
				Thread.sleep(2000);
	        } 
			catch (InterruptedException e) {
				e.printStackTrace();
	        }
	      }
		
	}

}
