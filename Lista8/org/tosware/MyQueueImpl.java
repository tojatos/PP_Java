package org.tosware;

import java.util.ArrayList;

public class MyQueueImpl<E> implements MyQueue<E> {
	private ArrayList<E> a;
	int f = 0, r = 0;
	public MyQueueImpl(int size) {
		 a = new ArrayList<>(size+1);
		 for (int i = 0; i <= size; i++) {
			 a.add(null);
		 }
	}

	@Override
	public void enqueue(E x) throws FullException {
		if (isFull()) throw new FullException("enq");
		a.set(r++, x);
		if(r == a.size()) r = 0;
	}

	@Override
	public void dequeue() {
		if (!isEmpty() && ++f == a.size()) f = 0;
	}

	@Override
	public E first() throws EmptyException {
		if (isEmpty()) throw new EmptyException("deq");
		return a.get(f);
	}

	@Override
	public boolean isEmpty() {
		return f == r;
	}

	@Override
	public boolean isFull() {
		return (r+1 == a.size()) ? f == 0 : r+1 == f;
	}

}
