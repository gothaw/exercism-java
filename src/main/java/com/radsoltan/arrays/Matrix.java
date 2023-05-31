package com.radsoltan.arrays;

import java.util.Arrays;

public class Matrix {
    private final int[][] matrix;

    Matrix(String matrixAsString) {
        matrix = Arrays.stream(matrixAsString.split("\n"))
                .map(row -> Arrays.stream(row.split("\s"))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray()
                ).toArray(int[][]::new);
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(matrix).mapToInt(row -> row[columnNumber - 1]).toArray();
    }
}
