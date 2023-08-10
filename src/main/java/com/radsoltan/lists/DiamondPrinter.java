package com.radsoltan.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiamondPrinter {
    List<String> printToList(char a) {
        List<String> list = new ArrayList<>();
        char capital = Character.toUpperCase(a);

        if (capital < 65 || capital > 90) {
            throw new IllegalArgumentException("Not a valid letter.");
        }
        int length = 2 * (capital - 65) + 1;
        String emptyRow = String.join("", Collections.nCopies(length, " "));

        for (int i = 0; i <= (capital - 65); i++) {
            StringBuilder row = new StringBuilder(emptyRow);
            row.setCharAt((int) (0.5 * length - i), (char) (i + 65));
            row.setCharAt((int) (0.5 * length + i), (char) (i + 65));
            list.add(row.toString());
        }
        List<String> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        reversed.remove(0);
        list.addAll(reversed);

        return list;
    }
}
