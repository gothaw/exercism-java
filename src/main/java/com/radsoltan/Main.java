package com.radsoltan;

import com.radsoltan.lists.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.unshift(10);
        list.unshift(20);
        list.unshift(30);
    }
}