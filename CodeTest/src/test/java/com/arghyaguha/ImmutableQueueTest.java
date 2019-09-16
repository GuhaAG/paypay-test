package com.arghyaguha;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ImmutableQueueTest {

	private final Queue<String> empty = ImmutableQueue.getEmptyInstance();
	private final Queue<String> one = ImmutableQueue.<String>getEmptyInstance()
				.enQueue("test 1");
	private final Queue<String> two = ImmutableQueue.<String>getEmptyInstance()
				.enQueue("test 1")
				.enQueue("test 2");

	@Test
	void enQueueEmptyQueueTest() {
		Queue<String> newQueue = empty.enQueue("new test");
		assertTrue(newQueue != empty);
		assertEquals(1, ((Countable) newQueue).size());
	}

	@Test
	void enQueueNullElementTest() {
		Queue<String> newQueue = empty.enQueue(null);
		assertEquals(1, ((Countable) newQueue).size());
	}

	@Test
	void enQueueQueueTest() {
		Queue<String> newQueue = one.enQueue("new test");
		assertTrue(newQueue != empty);
		assertEquals("test 1", newQueue.head());
	}

	@Test
	void enQueueDuplicateTest() {
		String elem = "new test";
		Queue<String> newQueue = empty.enQueue(elem).enQueue(elem);
		assertEquals(2, ((Countable) newQueue).size());
	}

	@Test
	void deQueueEmptyQueueTest() {
		Queue<String> newQueue = empty.deQueue();
		assertTrue(empty == newQueue);
	}

	@Test
	void deQueueElementTest() {
		Queue<String> newQueue = two.deQueue();
		assertEquals(1, ((Countable) newQueue).size());
		assertEquals("test 2", newQueue.head());
	}

	@Test
	void headTest() {
		assertEquals("test 1", one.head());
	}

	@Test
	void headEmptyQueueTest() {
		assertTrue(null == empty.head());
	}

	@Test
	void headNullContainingQueueTest() {
		Queue<String> newQueue = empty.enQueue(null);
		assertTrue(null == newQueue.head());
	}

	@Test
	void isEmptyOneElemQueueTest() {
		assertFalse(one.isEmpty());
	}

	@Test
	void isEmptyEmptyQueueTest() {
		assertTrue(empty.isEmpty());
	}

	@Test
	void alwaysIdenticalEmptyQueueTest() {
		assertTrue(ImmutableQueue.getEmptyInstance() == ImmutableQueue.getEmptyInstance());
	}

}