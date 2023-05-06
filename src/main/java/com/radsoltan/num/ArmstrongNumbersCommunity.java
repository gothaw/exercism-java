package com.radsoltan.num;

public class ArmstrongNumbersCommunity {
    boolean isArmstrongNumber(int numberToCheck) {
        String numberString = String.valueOf(numberToCheck);

        return numberToCheck == numberString.chars()
                .parallel()
                .map(c -> (int) Math.pow(Character.getNumericValue(c), numberString.length()))
                .sum();
    }
}
