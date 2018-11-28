package com.acc.interview.structures.interfaces;

import com.acc.interview.structures.implemetation.ArrayQueue;
//import com.sun.xml.internal.ws.api.server.AbstractServerAsyncTransport;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void ArrayQueue() {
        Queue<Integer> q = new ArrayQueue<>();
    }

    @Test
    void init() {
        Queue<Integer> q = new ArrayQueue<>();
        q.init(10);
    }

    @Test
    void enqueue() {
        Queue<Integer> q = new ArrayQueue<>();
        q.init(10);
        q.enqueue(5);
        Assert.assertEquals(1,q.size());

        q.enqueue(40);
        Assert.assertEquals(2,q.size());
    }

    @Test
    void dequeue() {
        Queue<Integer> q = new ArrayQueue<>();
        q.init(10);
        q.enqueue(1);
        q.enqueue(5);
        Assert.assertEquals(2,q.size());

        int value = q.dequeue();
        Assert.assertEquals(1,q.size());
        Assert.assertEquals(1,value);
    }

    @Test
    void peek() {
        Queue<Integer> q = new ArrayQueue<>();
        q.init(10);
        q.enqueue(1);
        q.enqueue(5);
        Assert.assertEquals(2,q.size());

        int value = q.peek();
        Assert.assertEquals(2,q.size());
        Assert.assertEquals(1,value);
    }

    @Test
    void isFull() {
        Queue<Integer> q = new ArrayQueue<>();
        q.init(5);
        Assert.assertEquals(false, q.isFull());

        q.enqueue(1);
        q.enqueue(5);
        q.enqueue(5);

        Assert.assertEquals(false, q.isFull());

        q.enqueue(5);
        q.enqueue(5);

        Assert.assertEquals(true, q.isFull());
    }

    @Test
    void isEmpty() {
        Queue<Integer> q = new ArrayQueue<>();
        q.init(5);
        Assert.assertEquals(true,q.isEmpty());

        q.enqueue(1);
        Assert.assertEquals(false,q.isEmpty());

    }
}