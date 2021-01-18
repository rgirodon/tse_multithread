package org.rygn.first_thread.condition;

public class ConsumerThread extends Thread {

	private final ItemQueue queue;
    
    public ConsumerThread(ItemQueue queue) {
       this.queue = queue;
    }

    @Override
    public void run() {
       
       try {
          
          do {
             Object number = queue.remove();
             
             System.out.println("[Consumer]: " + number);

             if(number == null) {
                return;
             }
          } while(!queue.isEmpty());
       } 
       catch (InterruptedException ex) {
          ex.printStackTrace();
       }
    }
}
