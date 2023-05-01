package com.radsoltan.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ResistorColorDuo {
    private static final Map<String, Integer> COLORS = new HashMap<>();
    private static final int COLOR_LIMIT = 2;
    static {
        COLORS.put("BLACK", 0);
        COLORS.put("BROWN", 1);
        COLORS.put("RED", 2);
        COLORS.put("ORANGE", 3);
        COLORS.put("YELLOW", 4);
        COLORS.put("GREEN", 5);
        COLORS.put("BLUE", 6);
        COLORS.put("VIOLET", 7);
        COLORS.put("GREY", 8);
        COLORS.put("WHITE", 9);
    }

    public int value(String[] colors) {
        String resistance = Arrays.stream(colors)
                .limit(COLOR_LIMIT)
                .map(color -> Integer.toString(COLORS.get(color.toUpperCase())))
                .reduce((a, b) -> a + b)
                .orElseThrow(IllegalArgumentException::new);
        return Integer.parseInt(resistance);
    }
}
