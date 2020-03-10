package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    private List<Integer> list;
    @Before
    public void helper() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
    }
    @Test
    public void deduplicate() {
        class ListSorterStub implements IListSorter{
            @Override
            public List<Integer> sort() {
                List<Integer> expected = new ArrayList<>();
                expected.add(1);
                expected.add(2);
                expected.add(2);
                expected.add(4);
                return expected;
            }
        }

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorterStub());

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        assertEquals(expected, distinct);
    }

}