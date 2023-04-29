package com.radsoltan.chars;

import java.util.Arrays;
import java.util.List;

public class Scrabble {
    private int score;

    public Scrabble(String word) {
        Character[] ones = {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'};
        Character[] twos = {'D', 'G'};
        Character[] threes = {'B', 'C', 'M', 'P'};
        Character[] fours = {'F', 'H', 'V', 'W', 'Y'};
        Character[] fives = {'K'};
        Character[] eights = {'J', 'X'};
        Character[] tens = {'Q', 'Z'};
        Integer[] scores = {1, 2, 3, 4, 5, 8, 10};
        List<Character[]> characterArrays = List.of(ones, twos, threes, fours, fives, eights, tens);

        for (Character[] array: characterArrays) {
            Arrays.sort(array);
        }

        word.toUpperCase().chars().forEach(c -> {
            for (int i = 0; i < scores.length; i++) {
                Character[] target = characterArrays.get(i);
                int j = Arrays.binarySearch(target, (char) c);
                if (j > -1) {
                    score += scores[i];
                    break;
                }
            }
        });
    }

    public int getScore() {
        return score;
    }
}
