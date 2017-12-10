package com.gordeev.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractQueueTest {
    private Queue<Integer> queueFourElements = getQueue();
    private Queue<Integer> queueSixElements = getQueue();

    protected abstract Queue<Integer> getQueue();

    @Before
    public void before() {
        for (int i = 0; i < 4; i++) {
            queueFourElements.enqueue(i);
        }
        for (int i = 0; i < 6; i++) {
            queueSixElements.enqueue(i);
        }
    }

    @Test
    public void testEnqueue() {
        assertEquals(6, queueSixElements.size());
        for (int i = 0; i < 6; i++) {
            queueSixElements.enqueue(i+6);
            assertEquals(7+i, queueSixElements.size());
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i), queueSixElements.dequeue());
        }
    }

    @Test
    public void testDequeue() {
        assertEquals(4, queueFourElements.size());
        for (int i = 0; i < 4; i++) {
            assertEquals(Integer.valueOf(i), queueFourElements.dequeue());
            assertEquals(3-i, queueFourElements.size());
        }
    }

    @Test
    public void testDequeueEnqueue() {
        assertEquals(4, queueFourElements.size());
        assertEquals(Integer.valueOf(0), queueFourElements.dequeue());
        assertEquals(3, queueFourElements.size());
        queueFourElements.enqueue(4);
        assertEquals(4, queueFourElements.size());
        queueFourElements.enqueue(5);
        assertEquals(5, queueFourElements.size());
        assertEquals(Integer.valueOf(1), queueFourElements.dequeue());
        assertEquals(4, queueFourElements.size());

    }

    @Test (expected = RuntimeException.class)
    public void testDequeueArrayIndexOutOfBoundsException() {
        assertEquals(4, queueFourElements.size());
        for (int i = 0; i < 5; i++) {
            queueFourElements.dequeue();
        }
    }

    @Test
    public void testPeek() {
        assertEquals(Integer.valueOf(0), queueSixElements.peek());
        assertEquals(6, queueSixElements.size());
        assertEquals(Integer.valueOf(0), queueSixElements.peek());
    }
}
