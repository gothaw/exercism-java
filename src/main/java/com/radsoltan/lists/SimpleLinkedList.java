package com.radsoltan.lists;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class SimpleLinkedList<T> {
    private int length;
    private Node head;

    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public SimpleLinkedList() {
        length = 0;
    }

    public SimpleLinkedList(T[] values) {
        for (T value: values) {
            push(value);
        }
    }

    public void push(T value) {
        Node node = new Node(value);

        if (this.head == null) {
            this.head = node;
        } else {
            Node lastNode = this.head;
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }

            lastNode.setNext(node);
        }
        length++;
    }

    public T pop() {
        // Empty list
        if (this.head == null) {
            throw new NoSuchElementException("List empty");
        }
        Node current = head;
        Node previous = null;
        Node next = head.getNext();
        // One Element
        if (next == null) {
            head = null;
            length--;

            return current.data;
        }
        while (next != null) {
            previous = current;
            current = next;
            next = current.getNext();
        }
        previous.setNext(null);
        length--;
        return current.data;
    }

    public void reverse() {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node next = current.getNext();
            current.setNext(previous);
            previous = current;
            head = current;
            current = next;
        }
    }

    public T[] asArray(Class<T> clazz) {
        T[] array = (T[]) Array.newInstance(clazz, length);

        Node current = head;
        for (int i = length - 1; i >= 0 ; i--) {
            array[i] = current.data;
            current = current.getNext();
        }

        return array;
    }

    public int size() {
        return this.length;
    }
}
