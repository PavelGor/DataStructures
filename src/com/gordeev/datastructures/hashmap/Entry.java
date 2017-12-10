package com.gordeev.datastructures.hashmap;

public class Entry<K,V> {
    private K key;
    private V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            return key.equals(entry.getKey()) && value.equals(entry.getValue());
        }
        return false;
    }

    @Override
    public String toString() {
        return "{" + key + "=" + value + '}';
    }
}
