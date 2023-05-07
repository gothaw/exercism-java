package com.radsoltan.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PangramCheckerTest {
    PangramChecker pangramChecker = new PangramChecker();

    @Test
    void perfectLowerCasePhraseIsPangram() {
        assertTrue(pangramChecker.isPangram("abcdefghijklmnopqrstuvwxyz"));
    }
}