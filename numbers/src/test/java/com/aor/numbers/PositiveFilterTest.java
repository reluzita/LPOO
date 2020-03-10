package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PositiveFilterTest {
    @Test
    public void accept() {
        PositiveFilter filter = new PositiveFilter();

        boolean test1 = filter.accept(1);
        boolean test2 = filter.accept(-1);
        boolean test3 = filter.accept(0);

        assertEquals(true, test1);
        assertEquals(false, test2);
        assertEquals(false, test3);

    }
}
