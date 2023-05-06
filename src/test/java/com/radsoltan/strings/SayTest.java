package com.radsoltan.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SayTest {
    Say say = new Say();

    @Test
    void shouldWorkForZero() {
        assertEquals("zero", say.say(0));
    }

    @Test
    void shouldWorkForOneToTwelve() {
        assertEquals("twelve", say.say(12));
    }

    @Test
    void shouldWorkForOneToFifteen() {
        assertEquals("fifteen", say.say(15));
    }

    @Test
    void shouldWorkForOneToFiftySix() {
        assertEquals("fifty-six", say.say(56));
    }

    @Test
    void shouldWorkForTwoHundredFiftyEight() {
        assertEquals("two hundred fifty-eight", say.say(258));
    }

    @Test
    void shouldWorkForBetweenThousandAndMillion() {
        assertEquals("fifty-six thousand two hundred seventy-nine", say.say(56279));
    }
}