package org.rygn.first_thread.basic;

public class BasicInheritsThread extends Thread {

	public BasicInheritsThread(String name) {

		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {

			System.out.println(Thread.currentThread().getName() + " - " + ++(BasicThreadMain.entier));

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
