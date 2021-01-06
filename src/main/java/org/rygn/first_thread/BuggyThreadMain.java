package org.rygn.first_thread;

public class BuggyThreadMain {

	public static Integer entier = 0;
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new BuggyThread());
		Thread t2 = new Thread(new BuggyThread());
		Thread t3 = new Thread(new BuggyThread());
		Thread t4 = new Thread(new BuggyThread());
	  
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
