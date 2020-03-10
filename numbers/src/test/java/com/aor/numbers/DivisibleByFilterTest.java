package com.aor.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisibleByFilterTest {
    @Test
    public void accept() {
        DivisibleByFilter filterPositive = new DivisibleByFilter(2);
        DivisibleByFilter filterOne = new DivisibleByFilter(1);
        DivisibleByFilter filterNegative = new DivisibleByFilter(-3);
        DivisibleByFilter filterZero = new DivisibleByFilter(0);

        boolean test1 = filterPositive.accept(1);
        boolean test2 = filterPositive.accept(4);
        boolean test3 = filterOne.accept(3);
        boolean test4 = filterOne.accept(0);
        boolean test5 = filterNegative.accept(6);
        boolean test6 = filterNegative.accept(-5);
        boolean test7 = filterZero.accept(4);

        assertEquals(false, test1);
        assertEquals(true, test2);
        assertEquals(true, test3);
        assertEquals(true, test4);
        assertEquals(true, test5);
        assertEquals(false, test6);
        assertEquals(false, test7);

    }
}
