package com.radsoltan.lists;

import java.util.stream.IntStream;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    public Classification getClassification() {
        int sum = IntStream.range(1, number)
                .filter(i -> number % i == 0)
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