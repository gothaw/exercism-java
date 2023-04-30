package com.radsoltan.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class HandShake {

    private static final Signal[] SIGNALS = Signal.values();
    private static final int ACTIONS_COUNT = 5;

    private enum Signal {
        WINK, DOUBLE_BLINK, CLOSE_YOUR_EYES, JUMP
    }

    public List<Signal> calculateHandshake(int number) {
        List<Signal> handshake = new ArrayList<>();
        String binary = Integer.toBinaryString(number);

        String actions = (binary.length() > ACTIONS_COUNT)
                ? binary.substring(binary.length() - ACTIONS_COUNT, binary.length())
                : String.format("%5s", binary).replaceAll(" ", "0");

        String reverseActions = new StringBuilder(actions).reverse().toString();

        IntStream.range(0, ACTIONS_COUNT)
                .forEach(i -> {
                    if (Character.getNumericValue(reverseActions.charAt(i)) == 1) {
                        if (i == ACTIONS_COUNT - 1) {
                            Collections.reverse(handshake);
                        } else {
                            handshake.add(SIGNALS[i]);
                        }
                    }
                });

        return handshake;
    }
}
