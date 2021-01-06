package org.rygn.first_thread.basic;

public class BasicThreadMain {

	public static Integer entier = 0;
	
	
	public static void main(String[] args) {
		
		Thread t1_1 = new Thread(new BasicImplementsThread(), "t1_1");
		Thread t1_2 = new Thread(new BasicImplementsThread(), "t1_2");
		Thread t1_3 = new Thread(new BasicImplementsThread(), "t1_3");
		Thread t1_4 = new Thread(new BasicImplementsThread(), "t1_4");
	  
		t1_1.start();
		t1_2.start();
		t1_3.start();
		t1_4.start();	
				
		Thread t2_1 = new BasicInheritsThread("t2_1");
		Thread t2_2 = new BasicInheritsThread("t2_2");
		Thread t2_3 = new BasicInheritsThread("t2_3");
		Thread t2_4 = new BasicInheritsThread("t2_4");
	  
		t2_1.start();
		t2_2.start();
		t2_3.start();
		t2_4.start();
	}
}
