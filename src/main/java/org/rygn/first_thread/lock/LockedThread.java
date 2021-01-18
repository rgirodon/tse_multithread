package org.rygn.first_thread.lock;

public class LockedThread implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {

			System.out.println(Thread.currentThread().getName() 
								+ " - " 
								+ LockedThreadMain.increment.incrementAndGet());

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
