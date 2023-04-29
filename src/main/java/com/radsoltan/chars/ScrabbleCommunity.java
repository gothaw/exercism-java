package com.radsoltan.chars;

import java.util.HashMap;
import java.util.Map;

public class ScrabbleCommunity {
    private final int score;
    private static final Map<Integer, Integer> scoreTable = new HashMap<>();
    static {
        "AEIOULNRST".chars().forEach(c -> scoreTable.put(c , 1));
        "DG".chars().forEach(c -> scoreTable.put(c, 2));
        "BCMP".chars().forEach(c -> scoreTable.put(c, 3));
        "FHVWY".chars().forEach(c -> scoreTable.put(c, 4));
        "K".chars().forEach(c -> scoreTable.put(c, 5));
        "JX".chars().forEach(c -> scoreTable.put(c, 8));
        "QZ".chars().forEach(c -> scoreTable.put(c, 10));
    }

    public ScrabbleCommunity(String word) {
        this.score = word.toUpperCase().chars().reduce(0, (a, b) -> a + scoreTable.get(b));
    }

    public int getScore() {
        return score;
    }
}
