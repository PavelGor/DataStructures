package com.gordeev.datastructures.hashmap;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HashMapTest {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    private HashMap<Integer, Integer> hashMapToAdd = new HashMap<>();
    private HashMap<Integer, Integer> hashMapToRetain = new HashMap<>();

    @Before
    public void before() {
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, i * 10);
        }
        for (int i = 9; i < 19; i++) {
            hashMapToAdd.put(i, i * 5);
        }
        for (int i = 0; i < 5; i++) {
            hashMapToRetain.put(i, i * 10);
        }
        hashMapToRetain.put(25, 25);
    }

    @Test
    public void testGet() {
        assertEquals(Integer.valueOf(10), hashMap.get(1));
    }

    @Test
    public void testContainsKey() {
        assertTrue(hashMap.containsKey(1));
        assertFalse(hashMap.containsKey(12));
        hashMap.put(13, null);
        assertTrue(hashMap.containsKey(13));
        hashMap.put(null, 12);
        assertTrue(hashMap.containsKey(null));
        assertEquals(12, hashMap.size());
    }

    @Test
    public void testPut() {
        assertEquals(10, hashMap.size());
        assertEquals(null, hashMap.put(11, 110));
        assertEquals(11, hashMap.size());
        assertEquals(Integer.valueOf(110), hashMap.put(11, 111));
        assertEquals(11, hashMap.size());
        assertEquals(Integer.valueOf(111), hashMap.get(11));
    }

    @Test
    public void testPutWithKeyNull() {
        hashMap.put(11, null);
        assertTrue(hashMap.get(11) == null);
        hashMap.put(null, 12);
        assertEquals(12, hashMap.size());
    }

    @Test
    public void testPutIfAbsent() {
        assertEquals(10, hashMap.size());
        assertEquals(Integer.valueOf(90), hashMap.get(9));
        assertEquals(Integer.valueOf(90), hashMap.putIfAbsent(9, 222));
        assertEquals(Integer.valueOf(90), hashMap.get(9));
        assertEquals(10, hashMap.size());
        assertEquals(null, hashMap.putIfAbsent(10, 222));
        assertEquals(11, hashMap.size());
        assertEquals(Integer.valueOf(222), hashMap.get(10));
    }

    @Test
    public void testRemove() {
        assertEquals(10, hashMap.size());
        assertEquals(null, hashMap.remove(12));
        assertEquals(10, hashMap.size());
        assertEquals(Integer.valueOf(90), hashMap.remove(9));
        assertEquals(9, hashMap.size());
        assertEquals(Integer.valueOf(50), hashMap.remove(5));
    }

    @Test
    public void testPutAll() {
        hashMap.putAll(hashMapToAdd);
        for (int i = 0; i < 9; i++) {
            assertEquals(Integer.valueOf(i*10),hashMap.get(i));
        }
        for (int i = 9; i < 19; i++){
            assertEquals(Integer.valueOf(i*5),hashMap.get(i));
        }
    }

    @Test
    public void testToString() {
        String expected = "[{0=0},{1=10},{2=20},{3=30},{4=40},{5=50},{6=60},{7=70},{8=80},{9=90}]";
        assertEquals(expected, hashMap.toString());
    }

    @Test
    public void testIterator(){
        int i = 0;
        Iterator iterator = hashMap.iterator();
        while (iterator.hasNext()){
            assertEquals(i,iterator.next());
            i++;
        }
    }

    @Test (expected = IllegalStateException.class)
    public void testIteratorWithoutHasNext(){
        Iterator iterator = hashMap.iterator();
        for (int i = 0; i < 12; i++) {
            iterator.next();
        }
    }
}
