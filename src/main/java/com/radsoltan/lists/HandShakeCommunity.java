package com.radsoltan.lists;

import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HandShakeCommunity {
    private static final Signal[] SIGNALS = Signal.values();
    private static final int SIGNALS_COUNT = SIGNALS.length;
    
    private enum Signal {
        WINK, DOUBLE_BLINK, CLOSE_YOUR_EYES, JUMP
    }

    public List<Signal> calculateHandshake(int n) {
        IntPredicate isBitOn = index -> ((1 << index) & n) > 0; // left shift operator by index binary and with n
        List<Signal> signals = IntStream.range(0, SIGNALS_COUNT)
                .filter(isBitOn)
                .mapToObj(i -> SIGNALS[i])
                .collect(Collectors.toList());
        if(isBitOn.test(SIGNALS_COUNT)) { // Checking 5th bit (shifting by SIGNALS_COUNT)
            Collections.reverse(signals);
        }
        return signals;
    }
}
