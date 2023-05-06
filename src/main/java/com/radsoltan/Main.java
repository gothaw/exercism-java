package com.radsoltan;


import com.radsoltan.lists.NaturalNumber;

public class Main {
    public static void main(String[] args) {
        NaturalNumber number = new NaturalNumber(12);

        System.out.println(number.getClassification());
    }
}