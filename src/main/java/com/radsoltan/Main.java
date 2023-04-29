package com.radsoltan;

import com.radsoltan.chars.ScrabbleCommunity;

public class Main {
    public static void main(String[] args) {
        ScrabbleCommunity scrabble = new ScrabbleCommunity("cabbage");
        System.out.println(scrabble.getScore());
    }
}