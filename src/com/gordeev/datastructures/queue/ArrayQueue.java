package com.gordeev.datastructures.queue;

public class ArrayQueue<E> implements Queue<E> {
    private E[] array;

    private int start;
    private int end;
    private int size;

    public ArrayQueue(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E value) {
        if (end == array.length - 1) {
                System.arraycopy(array, start, array, 0, array.length - start);
                end = end - start;
                start = 0;
        }

        array[end++] = value;
        size += 1;
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        start++;
        size--;
        return array[start - 1];
    }

    @Override
    public E peek() {
        return array[start];
    }

    @Override
    public int size() {
        return size;
    }
}
