package com.arghyaguha;

import java.util.NoSuchElementException;

public class ImmutableStackIterator<T> implements StackIterator<T> {

	private ImmutableStack<T> target;

	ImmutableStackIterator(ImmutableStack<T> target) {
		this.target = target;
	}

	@Override
	public boolean hasNext() {
		return !target.isEmpty();
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException("Elements exhausted");
		}
		T next = target.getElement();
		target = target.getNested();
		return next;
	}

	@Override
	public StackIterator<T> pop() {
		return new ImmutableStackIterator<>(target.getNested());
	}
}
