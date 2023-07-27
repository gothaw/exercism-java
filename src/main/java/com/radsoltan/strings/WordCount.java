package com.radsoltan.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> count = new HashMap<>();
        String targetString = input.replaceAll("\\s+", " ");

        Pattern pattern = Pattern.compile("\\w+(?:'\\w)?");
        Matcher matcher = pattern.matcher(targetString);

        while (matcher.find()) {
            String group = matcher.group().toLowerCase();
            if (count.containsKey(group)) {
                count.put(group, count.get(group) + 1);
            } else {
                count.put(group, 1);
            }
        }
        return count;
    }
}
