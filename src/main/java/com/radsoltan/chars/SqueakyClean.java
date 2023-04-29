package com.radsoltan.chars;

public class SqueakyClean {
    public static String clean(String identifier) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < identifier.length(); i++) {
            char c = identifier.charAt(i);

            if (Character.isSpaceChar(c)) {
                stringBuilder.append('_');
            } else if (Character.isISOControl(c)) {
                stringBuilder.append("CTRL");
            } else if (Character.isLetter(c) && i > 0 && identifier.charAt(i - 1) == '-') {
                stringBuilder.append(Character.toUpperCase(c));
            } else if (Character.isLetter(c) && !(c >= '\u03B1' && c <= '\u03C9')) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}