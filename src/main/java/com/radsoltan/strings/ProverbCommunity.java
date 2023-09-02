package com.radsoltan.strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProverbCommunity {
    private final String[] words;

    public ProverbCommunity(String[] words) {
        this.words = words;
    }

    public String recite() {
        return IntStream.range(0, words.length)
                .mapToObj(this::format)
                .collect(Collectors.joining("\n"));
    }

    private String format(int i) {
        return i != words.length - 1
                ? String.format("For want of a %s the %s was lost.\n", words[i], words[i + 1])
                : String.format("And all for the want of a %s.", words[0]);
    }
}
