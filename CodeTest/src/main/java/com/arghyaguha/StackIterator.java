package com.arghyaguha;

import java.util.Iterator;

public interface StackIterator<T> extends Iterator<T> {

	StackIterator<T> pop();

}
