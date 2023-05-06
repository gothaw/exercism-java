package com.radsoltan.lists;

import java.util.NoSuchElementException;

/**
 * Community Edition similar to mine
 * @param <T>
 */
public class DoublyLinkedList<T> {
    private Element<T> head = null;
    private int length = 0;

    public void push(T value) {
        length++;
        if (head == null) {
            head = new Element<>(value, null, null);
        } else {
            Element<T> current = head;
            Element<T> next = head.getNext();
            while (next != null) {
                current = next;
                next = next.getNext();
            }
            current.setNext(new Element<>(value, current, null));
        }
    }

    public T pop() {
        if (head == null) {
            throw new NoSuchElementException("empty list");
        }
        length--;
        Element<T> previous = null;
        Element<T> current = head;
        Element<T> next = head.getNext();
        if (next == null) {
            head = null;
            return current.value;
        }
        while (next != null) {
            previous = current;
            current = next;
            next = next.getNext();
        }
        previous.setNext(null);
        return current.value;
    }

    public void unshift(T value) {
        length++;
        if (head == null) {
            head = new Element<>(value, null, null);
        } else {
            Element<T> current = head;
            head = new Element<>(value, null, current);
            current.setPrev(head);
        }
    }

    public T shift() {
        if (head == null) {
            throw new NoSuchElementException("empty list");
        }
        length--;
        Element<T> current = head;
        Element<T> next = head.getNext();
        if (next == null) {
            head = null;
        } else {
            next.setPrev(null);
            head = next;
        }
        return current.value;
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Element<T> getPrev() {
            return prev;
        }

        public void setPrev(Element<T> prev) {
            this.prev = prev;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }
    }
}
