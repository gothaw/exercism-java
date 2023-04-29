package com.radsoltan.num;

import java.util.stream.IntStream;

public class DifferenceOfSquaresCalculator {
    int computeSquareOfSumTo(int input) {
        int sum = IntStream.range(1, input + 1).reduce(0, Integer::sum);
        return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.range(1, input + 1).reduce(0, (a, b) -> a + b * b);
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
