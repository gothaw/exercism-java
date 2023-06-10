package com.radsoltan.constructors;

import java.util.List;
import java.util.Optional;

public class TriangleCommunity {
    List<Double> triangle;

    TriangleCommunity(double side1, double side2, double side3) throws TriangleException {
        triangle = Optional.of(List.of(side1, side2, side3))
                .filter(this::isValid)
                .orElseThrow(TriangleException::new);
    }

    boolean isEquilateral() {
        return triangle.stream().distinct().count() == 1;
    }

    boolean isIsosceles() {
        return triangle.stream().distinct().count() < 3;
    }

    boolean isScalene() {
        return triangle.stream().distinct().count() == 3;
    }

    private boolean isValid(List<Double> triangle) {
        double sum = triangle.stream().mapToDouble(Double::doubleValue).sum();

        return triangle.stream().allMatch(side -> (sum - side) > side && side > 0);
    }

    private class TriangleException extends Exception {
    }
}
