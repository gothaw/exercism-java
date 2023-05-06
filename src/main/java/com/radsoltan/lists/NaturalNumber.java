package com.radsoltan.lists;

import java.util.HashSet;
import java.util.Set;

public class NaturalNumber {
    private final int number;
    private final Set<Integer> factors = new HashSet<>();

    public NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    public Classification getClassification() {
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                factors.add(i);
                if (i != 1) {
                    factors.add(number / i);
                }
            }
        }

        int sum = factors.stream()
                .reduce(Integer::sum)
                .orElse(0);

        return sum > number ? Classification.ABUNDANT :
                sum < number ? Classification.DEFICIENT :
                        Classification.PERFECT;
    }
}

enum Classification {
    DEFICIENT, PERFECT, ABUNDANT
}