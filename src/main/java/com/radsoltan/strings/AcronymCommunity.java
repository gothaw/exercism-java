package com.radsoltan.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcronymCommunity {
    private final String acronym;

    public AcronymCommunity(String phrase) {
        Matcher matcher = Pattern.compile("(?<=-|_|\\s|^)[A-Za-z]").matcher(phrase);
        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {
            stringBuilder.append(matcher.group().toUpperCase());
        }
        acronym = stringBuilder.toString();
    }

    public String get() {
        return acronym;
    }
}
