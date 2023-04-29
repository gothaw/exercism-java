package com.radsoltan.chars;

import java.util.Locale;
import java.util.regex.Pattern;

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

    // Community solution
    public static String cleanCommunity(String identifier) {
        var result = identifier.replace(' ', '_')
                .replaceAll("[α-ω]", "")
                .replaceAll("\\p{C}", "CTRL")
                .replaceAll("[^\\p{L}\\p{P}]", ""); // Matches any letter characters or all non punctuation https://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html
        var matcher = Pattern.compile("(.*)(-\\p{L})(.*)").matcher(result);

        if (matcher.matches()) {
            result = matcher.replaceAll(
                    matcher.group(1)
                            + matcher.group(2).toUpperCase(Locale.ROOT).substring(1)
                            + matcher.group(3)
            );
        }
        return result;
    }
}