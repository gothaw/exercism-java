package com.radsoltan.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public String translate(String sentence) {
        return Arrays.stream(sentence.split("\\s")).map(word -> {
            StringBuilder translated = new StringBuilder();

            if (isRuleOne(word)) {
                return translated.append(word).append("ay").toString();
            }

            StringBuilder cluster = new StringBuilder();
            int splitIndex = 0;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (isRuleTwo(c) || isRuleFour(word, cluster, c, i)) {
                    splitIndex = i;
                    if (isRuleThree(word, i, c)) {
                        cluster.append('u');
                        splitIndex++;
                    }
                    break;
                } else {
                    cluster.append(c);
                }
            }

            return translated.append(word.substring(splitIndex)).append(cluster).append("ay").toString();
        }).collect(Collectors.joining(" "));
    }

    private boolean isRuleOne(String word) {
        return VOWELS.contains(word.charAt(0)) || SPECIAL_VOWELS.contains(word.substring(0,2));
    }

    private boolean isRuleTwo(char character) {
        return VOWELS.contains(character);
    }

    private boolean isRuleThree(String word, int index, char character) {
        return character == 'u' && word.charAt(index - 1) == 'q';
    }

    private boolean isRuleFour(String word, StringBuilder cluster, char character, int index) {
        return (character == 'y' && cluster.length() > 1) || (word.length() == 2 && index == 1 && character=='y');
    }
}
