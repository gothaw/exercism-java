package com.radsoltan.num;

import java.math.BigInteger;

public class GrainsCommunity {
    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.valueOf(2).pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        // Sum of geometric progression of n items
        return BigInteger.valueOf(2).pow(65).subtract(BigInteger.ONE);
    }
}
