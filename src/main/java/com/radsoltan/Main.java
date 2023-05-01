package com.radsoltan;

import com.radsoltan.num.Grains;

public class Main {
    public static void main(String[] args) {
        Grains grains = new Grains();
        System.out.println(grains.grainsOnSquare(1));
        System.out.println(grains.grainsOnSquare(2));
        System.out.println(grains.grainsOnSquare(3));
        System.out.println(grains.grainsOnSquare(4));
    }
}