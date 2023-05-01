package com.radsoltan;


import com.radsoltan.arrays.ResistorColor;
import com.radsoltan.arrays.ResistorColorDuo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ResistorColorDuo resistorColorDuo = new ResistorColorDuo();
        System.out.println(resistorColorDuo.value(new String[]{"brown", "black"}));
    }
}