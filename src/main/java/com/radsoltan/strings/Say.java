package com.radsoltan.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Say {
    private static final Map<Long, String> SIMPLE_NUMBERS = new HashMap<>();
    private static final Map<Long, String> TEENS_PREFIX;
    private static final Map<Long, String> TENS_PREFIX;
    private static final List<String> LARGE_NUMBER_NAMES = new ArrayList<>(List.of(" thousand", " million", " billion", " trillion"));

    static {
        SIMPLE_NUMBERS.put(0L, "zero");
        SIMPLE_NUMBERS.put(1L, "one");
        SIMPLE_NUMBERS.put(2L, "two");
        SIMPLE_NUMBERS.put(3L, "three");
        SIMPLE_NUMBERS.put(4L, "four");
        SIMPLE_NUMBERS.put(5L, "five");
        SIMPLE_NUMBERS.put(6L, "six");
        SIMPLE_NUMBERS.put(7L, "seven");
        SIMPLE_NUMBERS.put(8L, "eight");
        SIMPLE_NUMBERS.put(9L, "nine");
        SIMPLE_NUMBERS.put(10L, "ten");
        SIMPLE_NUMBERS.put(11L, "eleven");
        SIMPLE_NUMBERS.put(12L, "twelve");
        TEENS_PREFIX = new HashMap<>();
        TEENS_PREFIX.put(3L, "thir");
        TEENS_PREFIX.put(4L, "four");
        TEENS_PREFIX.put(5L, "fif");
        TEENS_PREFIX.put(6L, "six");
        TEENS_PREFIX.put(7L, "seven");
        TEENS_PREFIX.put(8L, "eigh");
        TEENS_PREFIX.put(9L, "nine");
        TENS_PREFIX = new HashMap<>(TEENS_PREFIX);
        TENS_PREFIX.put(2L, "twen");
        TENS_PREFIX.put(4L, "for");
    }

    public String say(long number) {
        if (number < 0 || number >= Math.pow(10, 12)) {
            throw new IllegalArgumentException("Number must be greater than 0 and less than 1 000 000 000 000");
        }

        if (number <= 12) {
            return SIMPLE_NUMBERS.get(number);
        } else if (number < 20) {
            return TEENS_PREFIX.get(number % 10) + "teen";
        } else if (number < 100) {
            StringBuilder stringBuilder = new StringBuilder();
            Long decimalDigit = number / 10;
            stringBuilder.append(TENS_PREFIX.get(decimalDigit)).append("ty");
            if (number % 10 != 0) {
                stringBuilder.append("-").append(SIMPLE_NUMBERS.get(number % 10));
            }
            return stringBuilder.toString();
        }
        else if (number < 1000) {
            StringBuilder stringBuilder = new StringBuilder();
            Long hundredsDigit = number / 100;
            stringBuilder.append(SIMPLE_NUMBERS.get(hundredsDigit)).append(" hundred");
            if (number % 100 != 0) {
                long remainder = number % 100;
                stringBuilder.append(" ").append(say(remainder));
            }
            return stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String numberString = String.format("%,d", number);
            String[] digitGroups = numberString.split(",");

            for (int i = 0; i < digitGroups.length; i++) {
                long group = Long.parseLong(digitGroups[i]);
                if (group != 0) {
                    if (i != 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(say(group));
                    if (i != digitGroups.length - 1) {
                        stringBuilder.append(LARGE_NUMBER_NAMES.get(digitGroups.length - 2 - i));
                    }
                }
            }

            return stringBuilder.toString();
        }
    }
}
