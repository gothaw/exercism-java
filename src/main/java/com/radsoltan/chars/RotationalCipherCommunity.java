package com.radsoltan.chars;

public class RotationalCipherCommunity {
    private final int shiftKey;

    public RotationalCipherCommunity(int shiftKey) {
        if (shiftKey < 0 || shiftKey > 26) {
            throw new IllegalArgumentException();
        }
        this.shiftKey = shiftKey;
    }

    public String rotate(String data) {
        return data.chars()
                .mapToObj(this::shiftCharacter)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private int shiftCharacter(int codePoint) {
        if (!Character.isLetter(codePoint)) {
            return codePoint;
        }
        char first = Character.isUpperCase(codePoint) ? 'A' : 'a';
        return first + (codePoint - first + shiftKey) % 26;
    }
}
