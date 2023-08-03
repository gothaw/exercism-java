package com.radsoltan.strings;

public class IsogramCheckerCommunity {
    boolean isIsogram(String phrase) {
        String letters = phrase.replaceAll("-|\\s", "").toLowerCase();

        return letters.chars().distinct().count() == letters.length();
    }
}
