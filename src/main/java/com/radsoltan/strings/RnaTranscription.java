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
        return dnaStrand
                .chars()
                .map(Character::toUpperCase)
                .mapToObj(c -> {
                    if (MAPPING.containsKey((char) c)) {
                        return MAPPING.get((char) c).toString();
                    }
                    return String.valueOf(c);
                }).reduce("", (a, b) -> a + b);
    }
}
