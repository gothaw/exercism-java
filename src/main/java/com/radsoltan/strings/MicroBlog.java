package com.radsoltan.strings;

import java.util.stream.Collectors;

public class MicroBlog {
    private static final int CHAR_LIMIT = 5;

    public String truncate(String input) {
        return input.codePoints()
                .limit(CHAR_LIMIT)
                .mapToObj(Character::toString)
                .reduce("", (a, b) -> a + b);
    }
}
