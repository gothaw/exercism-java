package com.radsoltan.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Matrix {
    private final int[][] matrix;

    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");

        matrix = new int[rows.length][];
        IntStream.range(0, rows.length)
                .forEach(i -> {
                    String[] row = rows[i].split("\s");
                    matrix[i] = Arrays.stream(row)
                            .map(String::trim)
                            .mapToInt(Integer::parseInt)
                            .toArray();
                });
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(matrix).mapToInt(row -> row[columnNumber - 1]).toArray();
    }
}
