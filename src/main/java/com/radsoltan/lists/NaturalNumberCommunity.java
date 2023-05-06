package com.radsoltan.lists;

import java.util.stream.IntStream;

public class NaturalNumberCommunity {
    private final int number;

    public NaturalNumberCommunity(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    public Classification getClassification() {
        int sum = IntStream.rangeClosed(1, this.number / 2)
                .parallel()
                .filter(i -> number % i == 0)
                .sum();

        return sum > number ? Classification.ABUNDANT :
                sum < number ? Classification.DEFICIENT :
                        Classification.PERFECT;
    }
}
