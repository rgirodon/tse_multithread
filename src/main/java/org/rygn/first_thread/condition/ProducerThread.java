package org.rygn.first_thread.condition;

public class ProducerThread extends Thread {

	private final ItemQueue queue;
    
    public ProducerThread(ItemQueue queue) {
       this.queue = queue;
    }

    @Override
    public void run() {
       String[] numbers =
          {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

       try {
          
          for(String number: numbers) {
             
        	  System.out.println("[Producer]: " + number);
             
        	  queue.add(number);        	  
          }
          queue.add(null);
       } 
       catch (InterruptedException ex) {
          ex.printStackTrace();
       } 
    }
}
