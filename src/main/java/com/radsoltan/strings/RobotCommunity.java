package com.radsoltan.strings;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class RobotCommunity {
    private static final int CHAR_PREFIX_LENGTH = 2;
    private static final char MIN_CHAR = 'A';
    private static final char MAX_CHAR = 'Z';
    private static final int NUMBER_PREFIX_LENGTH = 3;
    private static final char MIN_NUMBER = '0';
    private static final char MAX_NUMBER = '9';
    private String name = generateName();
    private static final Set<String> usedNames = new HashSet<>();

    private String generateName() {
        String name = generateRandomPart(MIN_CHAR, MAX_CHAR, CHAR_PREFIX_LENGTH) +
                generateRandomPart(MIN_NUMBER, MAX_NUMBER, NUMBER_PREFIX_LENGTH);

        return usedNames.add(name) ? name : generateName();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        name = generateName();
    }

    private static String generateRandomPart(final char min, final char max, final int length) {
        return new Random()
                .ints(min, max)
                .limit(length)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }
}
