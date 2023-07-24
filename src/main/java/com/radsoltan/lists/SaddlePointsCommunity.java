package com.radsoltan.lists;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SaddlePointsCommunity {

    private final int rows;
    private final int columns;
    private final int[] rowsMax;
    private final int[] colsMin;

    public SaddlePointsCommunity(List<List<Integer>> values) {
        this.rows = values.size();
        this.columns = rows > 0 ? values.get(0).size() : 0;

        this.rowsMax = values.stream()
                .mapToInt(row -> row.stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .orElse(0)
                )
                .toArray();

        this.colsMin = IntStream.range(0, columns)
                .map(i ->
                    IntStream.range(0, rows)
                            .map(j -> values.get(j).get(i))
                            .min()
                            .orElse(0)
                ).toArray();

    }

    public Set<MatrixCoordinate> getSaddlePoints() {
        return IntStream.range(0, rows).boxed()
                .flatMap(row -> IntStream.range(0, columns)
                        .filter(column -> rowsMax[row] == colsMin[column])
                        .mapToObj(col -> new MatrixCoordinate(row + 1, col + 1)))
                .collect(Collectors.toSet());
    }

    private class MatrixCoordinate implements Comparable<MatrixCoordinate> {
        private final int row;
        private final int col;

        MatrixCoordinate(final int row, final int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Row: " + row + ", Column: " + col;
        }

        // Generated equals and hashcode.

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final MatrixCoordinate that = (MatrixCoordinate) o;

            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }

        @Override
        public int compareTo(MatrixCoordinate o) {
            int rowComparison = Integer.compare(row, o.row);
            return (rowComparison == 0) ? Integer.compare(col, o.col) : rowComparison;
        }
    }
}
