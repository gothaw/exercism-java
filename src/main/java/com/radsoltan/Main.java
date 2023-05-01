package com.radsoltan;


import com.radsoltan.arrays.ResistorColor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ResistorColor resistorColor = new ResistorColor();
        System.out.println(Arrays.toString(resistorColor.colors()));
    }
}