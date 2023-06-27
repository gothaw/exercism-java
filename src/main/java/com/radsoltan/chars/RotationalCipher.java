package com.radsoltan.chars;

import java.util.ArrayList;
import java.util.List;

public class RotationalCipher {
    private static final List<Character> CHARACTERS = new ArrayList<>();
    private final int shiftKey;

    static {
        for (char c = 'a'; c <= 'z'; c++) {
            CHARACTERS.add(c);
        }
    }

    public RotationalCipher(int shiftKey) {
        if (shiftKey < 0 || shiftKey > 26) {
            throw new IllegalArgumentException();
        }
        this.shiftKey = shiftKey;
    }

    public String rotate(String data) {
        return data.chars()
                .map(c -> Character.isLetter(c)
                    ? getShiftedCodePoint(c)
                    : c)
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private int getShiftedCodePoint(int codePoint) {
        boolean isUpperCase = Character.isUpperCase(codePoint);
        int index = CHARACTERS.indexOf((char) Character.toLowerCase(codePoint));
        int shiftedIndex = (index + shiftKey) % CHARACTERS.size();
        int shiftedCodePoint = CHARACTERS.get(shiftedIndex);

        return isUpperCase ? Character.toUpperCase(shiftedCodePoint) : shiftedCodePoint;
    }
}
