package com.radsoltan.lists;

import java.util.List;

public class Anagram {
    private final String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> candidates) {
        List<Character> wordChars = word.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .toList();

        return candidates
                .stream()
                .filter(candidate -> {
                    List<Character> candidateChars = candidate.toLowerCase().chars()
                            .mapToObj(c -> (char) c)
                            .sorted()
                            .toList();

                    return candidateChars.equals(wordChars) && !candidate.equalsIgnoreCase(word);
                }).toList();
    }
}
