package com.radsoltan.strings;

import java.util.HashMap;
import java.util.Map;

public class RaindropConverterCommunity {
    public static final Map<Integer, String> SOUNDS = new HashMap<>();
    static {
        SOUNDS.put(3, "Pling");
        SOUNDS.put(5, "Plang");
        SOUNDS.put(7, "Plong");
    }

    public String convert(int number) {
        return SOUNDS.keySet()
                .stream()
                .filter(key -> number % key == 0)
                .map(SOUNDS::get)
                .reduce((a, b) -> a + b)
                .orElse(Integer.toString(number));
    }
}
