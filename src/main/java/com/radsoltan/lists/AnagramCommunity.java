package com.radsoltan.lists;

import java.util.Arrays;
import java.util.List;

public class AnagramCommunity {
    private final String word;

    public AnagramCommunity(String word) {
        this.word = word;
    }

    public List<String> match(List<String> candidates) {
        int[] wordArray = word.toLowerCase().chars().sorted().toArray();
        return candidates.stream()
                .filter(candidate ->
                    Arrays.equals(wordArray, candidate.toLowerCase().chars().sorted().toArray()) && !candidate.equalsIgnoreCase(word)
                ).toList();
    }
}
