package org.tosware;

public interface MyStack<E> {
	public void push(E x) throws FullException;
	public E pop() throws EmptyException;
	public boolean isEmpty();
	public boolean isFull();
}
