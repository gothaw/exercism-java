package com.radsoltan.lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SaddlePoints {
    private final int rows;
    private final int columns;
    private final List<List<Integer>> values;

    public SaddlePoints(List<List<Integer>> values) {
        this.values = values;
        this.rows = values.size();
        // Assumption! Needs validation
        this.columns = values.size() != 0 ? values.get(0).size() : 0;
    }

    public Set<MatrixCoordinate> getSaddlePoints() {
        List<Integer> maxInRows = values.stream().map(Collections::max).toList();
        List<Integer> minInColumns = IntStream.range(0, columns).mapToObj(i ->
                Collections.min(values.stream().map(row -> row.get(i)).toList())
        ).toList();

        return IntStream.range(0, rows).boxed().flatMap(i ->
            IntStream.range(0, columns)
                    .filter(j -> maxInRows.get(i).equals(minInColumns.get(j)))
                    .mapToObj(j -> new MatrixCoordinate(i + 1, j + 1))
        ).collect(Collectors.toSet());
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
