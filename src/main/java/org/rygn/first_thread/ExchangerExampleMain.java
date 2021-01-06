package org.rygn.first_thread;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerExampleMain {

	public static void main(String[] args) {
		
		Exchanger<List<String>> ex = new Exchanger<>();
		
	    Thread t1 = new Thread(new ExchangerExampleFileFinder(ex));
	    
	    Thread t2 = new Thread(new ExchangerExampleFileMover(ex));
	
	    t1.start();
	    
	    t2.start();
	}
}
