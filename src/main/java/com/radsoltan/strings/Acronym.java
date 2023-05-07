package com.radsoltan.strings;

import java.util.Arrays;

public class Acronym {
    private final String acronym;

    public Acronym(String phrase) {
        String[] words = phrase.split("-|_|\\s");

        this.acronym = Arrays.stream(words)
                .filter(s -> s.length() > 0)
                .map(s -> s.charAt(0))
                .map(Character::toUpperCase)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String get() {
        return acronym;
    }
}
