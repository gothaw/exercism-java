package com.radsoltan.lists;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class SimpleLinkedListCommunity<T> {
    private Node<T> head;
    private int length;

    public SimpleLinkedListCommunity() {
        head = null;
        length = 0;
    }

    public SimpleLinkedListCommunity(T[] values) {
        for (T value: values) {
            push(value);
        }
    }

    public void push(T value) {
        length++;
        head = new Node<>(value, head);
    }

    public T pop() {
        if (length == 0) {
            throw new NoSuchElementException();
        }
        length--;
        T result = head.getData();
        head = head.getNext();
        return result;
    }

    public void reverse() {
        head = head.reverse();
    }

    public T[] asArray(Class<T> clazz) {
        T[] array = (T[]) Array.newInstance(clazz, length);

        Node<T> current = head;
        for (int i = 0; i < length ; i++) {
            array[i] = current.getData();
            current = current.getNext();
        }

        return array;
    }

    public int size() {
        return this.length;
    }
}
class Node<T> {
    private Node<T> next;
    private T data;

    Node(T data, Node<T> next) {
        this.next = next;
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public Node<T> reverse() {
        return this.reverse(null);  // If rest null reversing the head next to be null
    }

    private Node<T> reverse(Node<T> rest) {
        Node<T> next = this.next;
        this.next = rest;
        if (next != null) {
            return next.reverse(this);
        } else {
            return this;
        }
    }
}
