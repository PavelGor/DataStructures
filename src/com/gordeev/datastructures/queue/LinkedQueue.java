package com.gordeev.datastructures.queue;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head;
    private int size;

    @Override
    public void enqueue(E value) {
        Node<E> newNode = new Node<>(value);
        if (size == 0) {
            head = newNode;
        } else {
            Node<E> node = head;
            while (node.next != null){
                node = node.next;
            }
            node.next = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0){
            throw new RuntimeException("Queue is empty");
        }
        E value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public E peek() {
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }
}
