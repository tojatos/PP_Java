package org.tosware;

import java.util.ArrayList;

public class ArrayListStack<E> implements MyStack<E> {

	private ArrayList<E> list = new ArrayList<>();
	@Override
	public void push(E x) throws FullException {
		list.add(x);
	}

	@Override
	public E pop() throws EmptyException {
		if(isEmpty()) {
			throw new EmptyException("first");
		}
		E el = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return el;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}
	@Override
	public String toString() {
		return list.toString();
	}
}
