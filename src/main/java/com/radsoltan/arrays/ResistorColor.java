package com.radsoltan.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResistorColor {
    private static final Map<String, Integer> COLORS = new LinkedHashMap<>();
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

    public int colorCode(String color) {
        return COLORS.get(color.toUpperCase());
    }

    public String[] colors() {
        return COLORS.keySet()
                .stream()
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }
}
