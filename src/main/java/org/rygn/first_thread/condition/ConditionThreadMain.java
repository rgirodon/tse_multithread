package org.rygn.first_thread.condition;

public class ConditionThreadMain {

	public static void main(String[] args) throws InterruptedException {
	      
		ItemQueue itemQueue = new ItemQueue(6);

		//Create a producer and a consumer.
		Thread producer = new ProducerThread(itemQueue);
		Thread consumer = new ConsumerThread(itemQueue);

		//Start both threads.
		producer.start();
		consumer.start();

		//Wait for both threads to terminate.
		producer.join();
		consumer.join();
	}
}
