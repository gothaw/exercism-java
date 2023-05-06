package com.radsoltan.num;

public class ArmstrongNumbers {
    boolean isArmstrongNumber(int numberToCheck) {
        String numberString = Integer.toString(numberToCheck);

        double sum = numberString
                .chars()
                .parallel()
                .mapToDouble(c -> Math.pow(Character.getNumericValue(c), numberString.length()))
                .sum();

        return sum == numberToCheck;
    }
}
