package com.radsoltan.lists;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class DiamondPrinter {
    private static final int LETTER_A_CODE = 65;

    List<String> printToList(char a) {
        int size = 2 * (a - LETTER_A_CODE) + 1;
        String emptyRow = String.join("", Collections.nCopies(size, " "));

        return IntStream.range(0, size)
                .mapToObj(i -> {
                    StringBuilder row = new StringBuilder(emptyRow);

                    if (i < a - LETTER_A_CODE) {
                        row.setCharAt((int) (0.5 * size - i), (char) (i + LETTER_A_CODE));
                        row.setCharAt((int) (0.5 * size + i), (char) (i + LETTER_A_CODE));
                    } else {
                        // i = a - LETTER_A_CODE
                        row.setCharAt((int) (i - 0.5 * size + 1), (char) (a - (i - (a - LETTER_A_CODE))));
                        row.setCharAt((int) (size - (i - 0.5 * size) - 1), (char) (a - (i - (a - LETTER_A_CODE))));
                    }

                    return row.toString();
                })
                .toList();
    }
}
