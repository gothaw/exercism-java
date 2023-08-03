package com.radsoltan.strings;

import java.util.Set;
import java.util.stream.Collectors;

public class IsogramChecker {
    boolean isIsogram(String phrase) {
        String letters = phrase.replaceAll("-|\\s", "").toLowerCase();

        Set<Character> uniqueLetters = letters.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return uniqueLetters.size() == letters.length();
    }
}
