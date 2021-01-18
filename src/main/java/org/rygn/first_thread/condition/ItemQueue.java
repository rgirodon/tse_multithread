package org.rygn.first_thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ItemQueue {

	private Object[] items = null;

	private int current = 0;

	private int addIndex = 0;

	private int removeIndex = 0;

	private int capacity = 0;

	private final Lock lock;

	private final Condition isEmpty;

	private final Condition isFull;

	public ItemQueue(int capacity) {

		this.items = new Object[capacity];

		this.capacity = capacity;

		lock = new ReentrantLock();

		isEmpty = lock.newCondition();

		isFull = lock.newCondition();
	}

	public void add(Object item) throws InterruptedException {

		lock.lock();

		while (current == this.capacity) {

			isFull.await();
		}

		items[addIndex] = item;

		current++;

		// Go back to add at beginning when arrived at the end
		addIndex = (addIndex + 1) % capacity; 

		// Notify the consumer that there is data available.
		isEmpty.signal();

		lock.unlock();
	}

	public Object remove() throws InterruptedException {

		Object item = null;

		lock.lock();

		while (current == 0) {

			isEmpty.await();
		}

		item = items[removeIndex];

		// Go back to remove at the beginning when arrived at the end
		removeIndex = (removeIndex + 1) % capacity; 

		current--;

		// Notify the producer that there is space available.
		isFull.signal();

		lock.unlock();

		return item;
	}

	public boolean isEmpty() {

		return (current == 0);
	}
}
