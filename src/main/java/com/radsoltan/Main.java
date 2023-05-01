package com.radsoltan;

import com.radsoltan.arrays.DnDCharacter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DnDCharacter dnDCharacter = new DnDCharacter();
        System.out.println(dnDCharacter.modifier(3));
    }
}