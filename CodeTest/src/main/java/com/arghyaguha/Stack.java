package com.arghyaguha;

public interface Stack<T> {

	Stack<T> push(T t);
	Stack<T> pop();
	T peek();
	boolean isEmpty();

}
