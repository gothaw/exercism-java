package com.radsoltan;

import com.radsoltan.arrays.ProteinTranslatorCommunity;
import com.radsoltan.lists.SimpleLinkedList;

public class Main {
    public static void main(String[] args) {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.push("9");
        list.push("8");
        list.push("7");
        list.push("6");
        list.push("5");
        list.reverse();
        String[] array = new String[] {"5", "6", "Hello", "World"};
        list.asArray(String.class);
    }
}