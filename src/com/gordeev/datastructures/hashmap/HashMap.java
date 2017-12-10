package com.gordeev.datastructures.hashmap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringJoiner;

public class HashMap<K, V> implements Iterable{

    private int currentCapacity = 8;
    private ArrayList<Entry<K,V>>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMap() {
        buckets = new ArrayList[currentCapacity];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public V put(K key, V value) {
        ensureCapacity();
        Entry<K,V> newEntry = new Entry<>(key, value);
        Entry<K,V> entryToUpdate = getEntryElement(key);
        if (entryToUpdate != null) {
            V oldValue = entryToUpdate.getValue();
            entryToUpdate.setValue(value);
            return  oldValue;
        }
        buckets[getIndex(key)].add(newEntry);
        size++;
        return null;

    }

    public V putIfAbsent(K key, V value) {
        ensureCapacity();
        Entry<K,V> newEntry = new Entry<>(key, value);
        Entry<K,V> oldEntry = getEntryElement(key);
        if (oldEntry == null) {
            buckets[getIndex(key)].add(newEntry);
            size++;
            return null;
        }
        return oldEntry.getValue();
    }

    public V get(K key) {
        Entry<K,V> currentEntry = getEntryElement(key);
        if (currentEntry != null) {
            return currentEntry.getValue();
        }
        return null;
    }

    public V remove(K key) {
        Entry<K,V> entryToRemove = getEntryElement(key);

        if (entryToRemove != null) {
            int index = getIndex(key);
            ArrayList bucket = buckets[index];
            bucket.remove(entryToRemove);
            size--;
            return entryToRemove.getValue();
        }

        return null;
    }

    public void putAll(HashMap<K,V> hashMap) {
        for (Entry<K,V> element : hashMap.getEntryList()) {
            put(element.getKey(), element.getValue());
        }
    }

    public void putAllIfAbsent(HashMap<K,V> hashMap) {
        for (Entry<K,V> element : hashMap.getEntryList()) {
            putIfAbsent(element.getKey(), element.getValue());
        }
    }

    public HashMap retain(HashMap<K,V> hashMap) {
        for (Entry<K,V> element : hashMap.getEntryList()) {
            remove(element.getKey());
        }
        return this;
    }

    public boolean containsKey(K key) {
        return getEntryElement(key) != null;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size >= 0.75 * currentCapacity) {
            currentCapacity *= 2;
            ArrayList<Entry<K,V>>[] newBuckets = new ArrayList[currentCapacity];

            for (int i = 0; i < newBuckets.length; i++) {
                newBuckets[i] = new ArrayList<>();
            }

            for (ArrayList<Entry<K, V>> bucket : buckets) {
                for (Entry<K, V> element : bucket) {
                    newBuckets[getIndex(element.getKey())].add(element);
                }
            }
            buckets = newBuckets;
        }
    }

    private int getIndex(K key) {
        if (key == null) {
            return 1;
        }
        return Math.abs(key.hashCode() % currentCapacity);
    }

    private Entry<K,V> getEntryElement(K key) {
        for (Entry<K,V> element : buckets[getIndex(key)]) {
            if (key != null && key.equals(element.getKey())) {
                return element;
            } else if (element.getKey() == null) {
                return element;
            }
        }
        return null;
    }

    private ArrayList<Entry<K,V>> getEntryList() {
        ArrayList<Entry<K,V>> arrayList = new ArrayList<>(size);
        for (ArrayList<Entry<K,V>> bucket : buckets) {
            arrayList.addAll(bucket);
        }
        return arrayList;
    }

    public String toString() {
        StringJoiner result = new StringJoiner(",", "[", "]");
        for (ArrayList bucket : buckets) {
            for (Object element : bucket) {
                result.add(String.valueOf(element));
            }
        }
        return result.toString();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<K>{

        ArrayList<Entry<K,V>> array = getEntryList();
        int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public K next() {
            if (!hasNext()){
                throw new IllegalStateException();
            }
            K keyOfElement = array.get(index).getKey();
            index++;
            return keyOfElement;
        }
    }
}
