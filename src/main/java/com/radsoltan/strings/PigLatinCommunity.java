package com.radsoltan.strings;

public class PigLatinCommunity {
    private static final String PATTERN;
    static {
        String NO_YT_OR_XR_AT_START = "(?!yt|xr)";
        String QU_OR_CONSONANT_AT_START = "(qu|[^aeiou ])";
        String THEN_QU_OR_CONSONANT_EXCEPT_Y = "(qu|[^aeiouy ])*";
        String consonants = NO_YT_OR_XR_AT_START
                + QU_OR_CONSONANT_AT_START
                + THEN_QU_OR_CONSONANT_EXCEPT_Y;
        PATTERN = String.format("(?<consonants>%s)?(?<rest>\\w+)", consonants);
    }

    public static String translate(String input) {
        return input.replaceAll(PATTERN, "${rest}${consonants}ay");
    }
}
