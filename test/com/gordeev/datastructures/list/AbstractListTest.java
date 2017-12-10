package com.gordeev.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractListTest {

    private List<Integer> listWithZeroElements = getList();
    private List<Integer> listWithThreeElements = getList();
    private List<Integer> listWithTenElements = getList();

    protected abstract List<Integer> getList();

    @Before
    public void before() {
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        for (int i = 0; i < 10; i++) {
            listWithTenElements.add(i);
        }
    }

    @Test
    public void testAddInTheTail() {
        listWithTenElements.add(-1, 10);
        assertEquals(Integer.valueOf(-1), listWithTenElements.get(10));
        assertEquals(11, listWithTenElements.size());
    }

    @Test
    public void testAddInTheHead() {
        listWithTenElements.add(-1, 0);
        assertEquals(Integer.valueOf(-1), listWithTenElements.get(0));
        assertEquals(11, listWithTenElements.size());
    }

    @Test
    public void testAddInTheMiddle() {
        listWithThreeElements.add(-1, 1);
        assertEquals(Integer.valueOf(-1), listWithThreeElements.get(1));
        assertEquals(4, listWithThreeElements.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByInvalidIndex() {
        listWithThreeElements.add(4, 4);
    }

    @Test
    public void testGetByIndex() {
        assertEquals(Integer.valueOf(0), listWithThreeElements.get(0));
        assertEquals(Integer.valueOf(1), listWithThreeElements.get(1));
        assertEquals(Integer.valueOf(2), listWithThreeElements.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetByInvalidIndex() {
        listWithZeroElements.get(0);
    }

    @Test
    public void testRemoveByIndex() {
        Object removedObject = listWithThreeElements.remove(1);
        assertEquals(1, removedObject);
        assertEquals(2, listWithThreeElements.size());
        assertEquals(Integer.valueOf(0), listWithThreeElements.get(0));
        assertEquals(Integer.valueOf(2), listWithThreeElements.get(1));
    }

    @Test
    public void testSet() {
        listWithThreeElements.set(-1, 1);
        assertEquals(Integer.valueOf(-1), listWithThreeElements.get(1));
        assertEquals(3, listWithThreeElements.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testClear() {
        listWithThreeElements.clear();
        listWithThreeElements.get(0);
    }

    @Test
    public void testContains() {
        assertTrue(listWithTenElements.contains(1));
        assertTrue(listWithTenElements.contains(2));
        assertFalse(listWithTenElements.contains(12));
    }

    @Test
    public void testIndexOf() {
        assertEquals(3, listWithTenElements.indexOf(3));
        assertEquals(1, listWithTenElements.indexOf(1));
        assertEquals(-1, listWithTenElements.indexOf(12));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(8, listWithTenElements.lastIndexOf(8));
    }

    @Test
    public void testIterator(){
        int i = 0;
        Iterator iterator = listWithThreeElements.iterator();
        while (iterator.hasNext()){
            assertEquals(i,iterator.next());
            i++;
        }
    }

    @Test (expected = IllegalStateException.class)
    public void testIteratorWithoutHasNext(){
        Iterator iterator = listWithThreeElements.iterator();
        for (int i = 0; i < 5; i++) {
            iterator.next();
        }
    }
}
