package com.radsoltan.chars;

import java.util.Locale;
import java.util.regex.Pattern;

public class SqueakyCleanCommunity {
    public static String clean(String identifier) {
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
