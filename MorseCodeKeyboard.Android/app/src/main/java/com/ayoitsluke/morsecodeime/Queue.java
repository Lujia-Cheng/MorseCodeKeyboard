package com.ayoitsluke.morsecodeime;

import java.util.EmptyStackException;


/**
 * First in first out
 *
 * @param <T>
 */
public class Queue<T> {
    /**
     * @param <T>
     */
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T newData) {
            this.data = newData;
        }

        public Node(T newData, Node<T> next) {
            this(newData);
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T newData) {
            this.data = newData;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public boolean isEnd() {
            return this.next == null;
        }

    }

    private Node<T> firstNode;
    private Node<T> lastNode;


    public Queue() {
        clear();
    }

    public int getSize() {
        int counter = 0;
        for (Node<T> n = firstNode; n != null; n = n.next) {
            counter++;
        }
        return counter;
    }

    /**
     * add to last
     *
     * @param newData
     */
    public void enqueue(T newData) {
        Node<T> newNode = new Node<>(newData);
        if (firstNode == null && lastNode == null) {
            // handle empty queue
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }
        lastNode = newNode;
    }

    /**
     * remove from first
     *
     * @return
     */
    public T dequeue() {
        if (firstNode == null || lastNode == null) {
            throw new EmptyStackException();
        }
        Node<T> curr = firstNode;
        firstNode = firstNode.next;
        return curr.data;
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> curr = firstNode;
        while (curr != null) {
            sb.append(curr.data);
            sb.append(",");
            curr = curr.next;
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
