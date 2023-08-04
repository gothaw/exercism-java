package com.radsoltan.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PigLatinTranslator {
    private static final Set<Character> VOWELS = new HashSet<>();
    private static final Set<String> SPECIAL_VOWELS = new HashSet<>();
    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        SPECIAL_VOWELS.add("xr");
        SPECIAL_VOWELS.add("yt");
    }

    public String translate(String word) {
        StringBuilder translated = new StringBuilder();

        if (isBeginWithVowel(word)) {
            // Rule 1
            return translated.append(word).append("ay").toString();
        }

        // Rule 3 and 4
        StringBuilder cluster = new StringBuilder();
        int splitIndex = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!VOWELS.contains(c) && !(c == 'y' && cluster.length() > 1)) {
                cluster.append(c);
            } else {
                splitIndex = i;
                if (c == 'u' && word.charAt(i - 1) == 'q' && i > 1) {
                    cluster.append('u');
                    splitIndex++;
                }
                break;
            }
        }
        return translated.append(word.substring(splitIndex)).append(cluster).append("ay").toString();
    }

    private boolean isBeginWithVowel(String word) {
        return VOWELS.contains(word.charAt(0)) || SPECIAL_VOWELS.contains(word.substring(0,2));
    }
}
