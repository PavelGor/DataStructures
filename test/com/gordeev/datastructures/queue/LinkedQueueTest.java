package com.gordeev.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedQueueTest extends AbstractQueueTest {

    @Override
    protected Queue<Integer> getQueue() {
        return new LinkedQueue<>();
    }
}