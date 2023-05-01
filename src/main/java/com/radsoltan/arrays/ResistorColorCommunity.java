package com.radsoltan.arrays;

import java.util.Arrays;

public class ResistorColorCommunity {
    private static final String[] COLORS = new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    int colorCode(String color) {
        return Arrays.asList(colors()).indexOf(color);
    }

    String[] colors() {
        return COLORS;
    }
}
