package org.tosware;

public class Main {

	public static void main(String[] args) throws Exception {
		MyQueueImpl<Integer> queue = new MyQueueImpl<>(2);
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		queue.enqueue(2);
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		System.out.println(queue.first());
		queue.enqueue(3);
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		System.out.println(queue.first());
		queue.dequeue();
		System.out.println(queue.first());
		queue.dequeue();
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
	}

}
