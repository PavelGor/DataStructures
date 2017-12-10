package com.gordeev.datastructures.queue;

public interface Queue<T> {

    void enqueue(T value);

    T dequeue();

    T peek();

    int size();

}
