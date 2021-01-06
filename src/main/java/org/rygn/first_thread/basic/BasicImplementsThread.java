package org.rygn.first_thread.basic;

public class BasicImplementsThread implements Runnable {

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
