package com.radsoltan.strings;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Robot {
    private static final Set<String> NAMES = new HashSet<>();

    private String name;

    public Robot() {
        this.name = generateName();
    }

    public String getName() {
        if (this.name == null) {
            this.name = generateName();
        }
        return this.name;
    }

    public void reset() {
        this.name = null;
    }

    private String generateName() {
        String name = String.format("%s%s%d%d%d", getRandomLetter(), getRandomLetter(), getRandomDigit(), getRandomDigit(), getRandomDigit());
        return NAMES.add(name) ? name : generateName();
    }

    private char getRandomLetter() {
        Random random = new Random();
        return (char) (random.nextInt(65, 65 + 26));
    }

    private int getRandomDigit() {
        Random random = new Random();
        return random.nextInt(0, 10);
    }
}