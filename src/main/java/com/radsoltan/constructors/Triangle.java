package com.radsoltan.constructors;

import java.util.stream.DoubleStream;

public class Triangle {
    private final double side1;
    private final double side2;
    private final double side3;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        double max = this.maxSide(side1, side2, side3);
        double sum = this.sum(side1, side2, side3);
        if (this.isIllegal(max, sum)) {
            throw new TriangleException();
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    boolean isEquilateral() {
        return side1 == side2 && side1 == side3 && side2 == side3;
    }

    boolean isIsosceles() {
        return side1 == side2 || side1 == side3 || side2 == side3;
    }

    boolean isScalene() {
        return side1 != side2 && side1 != side3 && side2 != side3;
    }

    private double maxSide(double side1, double side2, double side3) {
        return DoubleStream.of(side1, side2, side3).max().orElse(0);
    }

    private double sum(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    private boolean isIllegal(double maxSide, double sum) {
        return maxSide >= (sum - maxSide);
    }

    private class TriangleException extends Exception {
    }
}
