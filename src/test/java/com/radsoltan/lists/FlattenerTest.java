package com.radsoltan.lists;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlattenerTest {

    private Flattener flattener;
    @BeforeEach
    public void setUp() {
        flattener = new Flattener();
    }
    @Test
    public void testFlatListIsPreserved() {
        assertEquals(List.of(0, '1', "two"), flattener.flatten(List.of(0, '1', "two")));
    }
    @Test
    public void testASingleLevelOfNestingWithNoNulls() {
        assertEquals(
                List.of(1, '2', 3, 4, 5, "six", "7", 8),
                flattener.flatten(List.of(1, List.of('2', 3, 4, 5, "six", "7"), 8)));
    }
    @Test
    public void testFiveLevelsOfNestingWithNoNulls() {
        assertEquals(
                List.of(0, '2', 2, "three", '8', 100, "four", 50, "-2"),
                flattener.flatten(List.of(0,
                        '2',
                        List.of(List.of(2, "three"),
                                '8',
                                100,
                                "four",
                                List.of(List.of(List.of(50)))), "-2")));
    }
    @Test
    public void testSixLevelsOfNestingWithNoNulls() {
        assertEquals(
                List.of("one", '2', 3, '4', 5, "six", 7, "8"),
                flattener.flatten(List.of("one",
                        List.of('2',
                                List.of(List.of(3)),
                                List.of('4',
                                        List.of(List.of(5))), "six", 7), "8")));
    }

}