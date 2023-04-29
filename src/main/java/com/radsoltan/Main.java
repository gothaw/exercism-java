package com.radsoltan;

import com.radsoltan.chars.Scrabble;

public class Main {
    public static void main(String[] args) {
        Scrabble scrabble = new Scrabble("at");
        System.out.println(scrabble.getScore());
    }
}