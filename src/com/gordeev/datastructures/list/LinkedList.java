package com.gordeev.datastructures.list;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    @Override
    public void add(E value) {
        add(value, size);
    }

    @Override
    public void add(E value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + (size - 1) + "exclusive." + "Current index = " + index);
        }

        if (value == null) {
            throw new NullPointerException();
        }

        Node<E> newNode = new Node<>(value);
        Node<E> node;
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            node = getNode(index);
            node.prev.next = newNode;
            newNode.next = node;
            newNode.prev = node.prev;
            node.prev = newNode;
        }

        size++;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        Node<E> objectToRemove;

        if (index == 0) {
            objectToRemove = head;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            objectToRemove = tail;
            tail = tail.prev;
            tail.prev = null;
        } else {
            objectToRemove = getNode(index);
            objectToRemove.next.prev = objectToRemove.prev;
            objectToRemove.prev.next = objectToRemove.next;
        }

        size--;
        return objectToRemove.value;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        Node<E> tmp = getNode(index);
        return tmp.value;
    }

    @Override
    public E set(E value, int index) {
        validateIndex(index);
        if (value == null) {
            throw new NullPointerException();
        }
        Node<E> node = getNode(index);
        node.value = value;
        return node.value;
    }

    @Override
    public void clear() {
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
            head = null;
            head = node;
        }
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(E value) {
        int index = 0;
        Node<E> node = head;

        do {
            if (node.value.equals(value)) {
                return index;
            }
            node = node.next;
            index++;
        } while (node != null);

        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        int index = 0;
        Node<E> node = tail;

        do {
            if (node.value.equals(value)) {
                return size - index - 1;
            }
            node = node.prev;
            index++;
        } while (node != null);

        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + (size - 1) + "exclusive." + "Current index = " + index);
        }
    }

    private Node<E> getNode(int index) {
        Node<E> node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    class MyIterator implements Iterator<E> {

        Node<E> indexNode = head;

        @Override
        public boolean hasNext() {
            if (isEmpty()){
                return false;
            }
            return indexNode.next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            Node<E> node = indexNode;
            indexNode = indexNode.next;
            return node.value;
        }
    }
}
