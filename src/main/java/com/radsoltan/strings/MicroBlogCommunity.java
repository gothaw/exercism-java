package com.radsoltan.strings;

public class MicroBlogCommunity {
    private static final int CHARACTER_LIMIT = 5;

    public String truncate(String input) {
        return input.length() < 5 ? input : input.substring(0, input.offsetByCodePoints(0, CHARACTER_LIMIT));
    }
}
