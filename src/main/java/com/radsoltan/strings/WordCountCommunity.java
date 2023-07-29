package com.radsoltan.strings;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCountCommunity {
    public Map<String, Integer> phrase(String word) {
        return Arrays.stream(word
                        .toLowerCase()
                        .replaceAll("[^a-z0-9' ]", " ")
                        .trim()
                        .split("\\s+"))
                .map(chunk -> chunk.replaceAll("^'|'$", "")) // replaces single quotes
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, chunk -> chunk.getValue().intValue()));

    }
}
