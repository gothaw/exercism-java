package com.radsoltan;

import com.radsoltan.num.SpaceAge;

public class Main {
    public static void main(String[] args) {
        SpaceAge spaceAge = new SpaceAge(2000000000L);

        System.out.println(spaceAge.onSaturn());
    }
}