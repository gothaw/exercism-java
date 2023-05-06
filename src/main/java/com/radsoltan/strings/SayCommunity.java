package com.radsoltan.strings;

public class SayCommunity {

    private static final String[] UNDER_TWENTY = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};

    private static final String[] TENS = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public String say(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }

        if (number < 20) {
            return UNDER_TWENTY[(int) number];
        }

        if (number < 100) {
            if (number % 10 == 0) {
                int i = (int) (number / 10) - 2;
                return TENS[i];
            }
            return say(number/10 * 10) + "-" + say(number % 10);
        }

        if (number < 1000) {
            return sayNumberAboveHundred(number, 100, "hundred");
        }

        if (number < 1_000_000) {
            return sayNumberAboveHundred(number, 1_000, "thousand");
        }

        if (number < 1_000_000_000) {
            return sayNumberAboveHundred(number, 1_000_000, "million");
        }

        if (number < 1_000_000_000_000L) {
            return sayNumberAboveHundred(number, 1_000_000_000, "billion");
        }

        throw new IllegalArgumentException("Number must be less than 10e12");
    }

    private String sayNumberAboveHundred(long number, long modulo, String suffix) {
        var division = number / modulo;
        var remainder = number % modulo;
        if (remainder == 0) {
            return say(division) + " " + suffix;
        } else {
            return say(division)  + " " + suffix + " " + say(remainder);
        }
    }
}
