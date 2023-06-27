package com.radsoltan.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PangramChecker {
    private static final Set<Character> CHARACTERS = new HashSet<>();

    static {
        for (char c = 'a'; c <= 'z'; c++) {
            CHARACTERS.add(c);
        }
    }

    public boolean isPangram(String input) {
        String missingLetters = CHARACTERS.stream()
                .filter(c -> !input.toLowerCase().contains(String.valueOf(c)))
                .map(String::valueOf)
                .collect(Collectors.joining());

        return missingLetters.length() == 0;
    }
}
