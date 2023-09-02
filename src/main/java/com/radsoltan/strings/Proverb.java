package com.radsoltan.strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Proverb {
    private final String[] words;
    public Proverb(String[] words) {
        this.words = words;
    }
    public String recite() {
        if (words.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String forLines = IntStream.range(1, words.length)
                .mapToObj(i -> String.format("For want of a %s the %s was lost.\n", words[i - 1], words[i]))
                .collect(Collectors.joining());

        stringBuilder.append(forLines);
        stringBuilder.append(String.format("And all for the want of a %s.", words[0]));
        return stringBuilder.toString();
    }
}
