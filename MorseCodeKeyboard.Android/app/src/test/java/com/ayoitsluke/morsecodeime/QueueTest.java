package com.ayoitsluke.morsecodeime;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class QueueTest {
    private Queue<String> testQueue;
    private Queue<String> emptyQueue;

    @Before
    public void testEnqueue() {
        testQueue.enqueue("1");
        testQueue.enqueue("2");
        testQueue.enqueue("3");
        testQueue.enqueue("4");
        testQueue.enqueue("5");
    }

    @Test
    public void testDequeue() {
        assertEquals("1", testQueue.dequeue());
        assertEquals("2", testQueue.dequeue());
        assertEquals("3", testQueue.dequeue());
        assertEquals("4", testQueue.dequeue());
        assertEquals("5", testQueue.dequeue());

        Exception thrown = null;
        try {
            testQueue.dequeue();
        } catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }

    @Test
    public void testClear() {
        emptyQueue.enqueue("test");
        assertFalse(emptyQueue.isEmpty());
        assertEquals("test", emptyQueue.toString());

        emptyQueue.clear();
        assertTrue(emptyQueue.isEmpty());
        assertEquals("", emptyQueue.toString());

        emptyQueue.enqueue("test1");
        assertFalse(emptyQueue.isEmpty());
        assertEquals("test1", emptyQueue.toString());

        emptyQueue.clear();
        assertTrue(emptyQueue.isEmpty());
        assertEquals("", emptyQueue.toString());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(testQueue.isEmpty());
        assertTrue(emptyQueue.isEmpty());
        emptyQueue.enqueue("test1");
        assertFalse(emptyQueue.isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals("1,2,3,4,5", testQueue.toString());
        assertEquals("", emptyQueue.toString());
    }

}
