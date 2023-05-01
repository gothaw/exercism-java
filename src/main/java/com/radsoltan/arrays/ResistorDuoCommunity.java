package com.radsoltan.arrays;

import java.util.List;

public class ResistorDuoCommunity {
    private static final List<String> COLORS = List.of("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white");

    public int value(String[] colors) {
        return COLORS.indexOf(colors[0]) * 10 + COLORS.indexOf(colors[1]);
    }
}
