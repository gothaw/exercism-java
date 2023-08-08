package com.radsoltan.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinCommunitySimple {
    private final StringBuilder translated = new StringBuilder();

    public String translate(String sentence) {
        Pattern vowel = Pattern.compile("^([aeiou]|yt|xr)");
        Pattern consonant = Pattern.compile("^([^aeiou]?qu|[^aeiouy]+|y(?=[aeiou]))");

        for (String word: sentence.split(" ")) {
            if (vowel.matcher(word).find())
                translated.append(word);
            else {
                Matcher z = consonant.matcher(word);
                if (z.find())
                    translated.append(word.substring(z.end())).append(z.group());
            }
            translated.append("ay ");
        }
        return translated.substring(0, translated.length() - 1);
    }
}
