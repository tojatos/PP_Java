package org.tosware;

public class Main {

	public static void main(String[] args) throws Exception {
		MyStack<Integer> stack1 = new ArrayListStack<>();
		MyStack<Integer> stack2 = new ArrayStack<>(2);
		System.out.println(stack1.isEmpty());
		System.out.println(stack1.isFull());
		System.out.println(stack2.isEmpty());
		System.out.println(stack2.isFull());
		stack1.push(1);
		stack2.push(2);
		System.out.println(stack1.isEmpty());
		System.out.println(stack2.isEmpty());
		stack2.push(3);
		System.out.println(stack2.isFull());
		stack1.push(4);
		stack1.push(5);
		stack1.push(6);
		stack1.push(7);
		System.out.println(stack1);
		System.out.println(stack2);
		MyStack<Integer> stack3 = new ArrayStack<>(4);
		stack3.push(99);
		System.out.println(stack1);
		System.out.println(stack3);
		move(stack3, stack1);
		System.out.println(stack1);
		System.out.println(stack3);
	}
	public static <E> void move(MyStack<E> s1, MyStack<E> s2)
	{
		while(!(s1.isFull() || s2.isEmpty())) {
			try {
				s1.push(s2.pop());
			} catch (FullException | EmptyException e) {
				// never happens
			}
		}
	}

}
