package com.radsoltan.num;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Grains {
    private final List<BigInteger> grains = new ArrayList<>();
    private BigInteger grainsOnBoard = BigInteger.valueOf(0);
    private final static int BOARD_SIZE = 64;

    public Grains() {
        IntStream.range(0, BOARD_SIZE).forEach(i -> {
            if (i == 0) {
                grains.add(BigInteger.ONE);
            } else {
                grains.add(grains.get(i - 1).multiply(BigInteger.TWO));
            }
            grainsOnBoard = grainsOnBoard.add(grains.get(i));
        });
    }

    public BigInteger grainsOnSquare(final int square) {
        if (square > BOARD_SIZE || square < 1) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return grains.get(square - 1);
    }

    public BigInteger grainsOnBoard() {
        return grainsOnBoard;
    }

}
