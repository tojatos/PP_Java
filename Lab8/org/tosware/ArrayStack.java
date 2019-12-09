package org.tosware;

import java.util.Arrays;

public class ArrayStack<E> implements MyStack<E> {

	private Object[] arr;
	private int ptr = 0;
	public ArrayStack(int stackSize) {
		arr = new Object[stackSize];
	}
	@Override
	public void push(E x) throws FullException {
		if(isFull()) throw new FullException("push");
		arr[ptr++] = x;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() throws EmptyException {
		if(isEmpty()) throw new EmptyException("pop");
		return (E)arr[--ptr];
	}

	@Override
	public boolean isEmpty() {
		return ptr == 0;
	}

	@Override
	public boolean isFull() {
		return ptr >= arr.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

}
