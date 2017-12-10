package com.gordeev.datastructures.list;

import java.util.Iterator;

public class ArrayList<E> implements List<E>{
    private E[] array = (E[]) new Object[5];
    private int size;

    @Override
    public void add(E value) {
        add(value, size);
    }

    @Override
    public void add(E value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + size + "exclusive." + "Current index = " + index);
        }
        if (value == null){
            throw new NullPointerException();
        }
        if (array.length == size) {
            E[] newArray = (E[]) new Object[size * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        E objectToRemove = array[index];

        System.arraycopy(array, index + 1, array, index, size - index);
        array[size] = null;
        size--;
        return objectToRemove;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public E set(E value, int index) {
        validateIndex(index);
        if (value == null){
            throw new NullPointerException();
        }
        array[index] = value;
        return array[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
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
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
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

    class MyIterator implements Iterator<E>{

        int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new IllegalStateException();
            }
            E element = array[index];
            index++;
            return element;
        }
    }

    public String toString() {
        StringBuilder resultString = new StringBuilder("[");

        for (int i = 0; i < size - 1; i++) {
            resultString.append(array[i]).append(", ");
        }
        resultString.append(array[size - 1]).append("]");
        return resultString.toString();
    }

}
