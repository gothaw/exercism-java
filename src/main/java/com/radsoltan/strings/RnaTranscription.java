package com.radsoltan.strings;

import java.util.HashMap;
import java.util.Map;

public class RnaTranscription {
    private static final Map<Character, Character> MAPPING = new HashMap<>();

    static {
        MAPPING.put('G', 'C');
        MAPPING.put('C', 'G');
        MAPPING.put('T', 'A');
        MAPPING.put('A', 'U');
    }

    public String transcribe(String dnaStrand) {
        return dnaStrand.chars().mapToObj(c -> {
            char strand = (char) Character.toUpperCase(c);
            if (MAPPING.containsKey(strand)) {
                return MAPPING.get(strand).toString();
            }
            return String.valueOf(strand);
        }).reduce("", (a, b) -> a + b);
    }
}
