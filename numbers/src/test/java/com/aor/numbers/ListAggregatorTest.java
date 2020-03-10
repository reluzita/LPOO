package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    private List<Integer> helper() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(4);
        return list;
    }
    @Test
    public void sum() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(4, max);
    }

    @Test
    public void max2() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void min() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        /*
        class ListDedeuplicatorStub implements IListDeduplicator{
            @Override
            public List<Integer> deduplicate(IListSorter listSorter) {
                List<Integer> expected = new ArrayList<>();
                expected.add(1);
                expected.add(2);
                expected.add(4);
                expected.add(5);
                return expected;
            }
        }*/

        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.any(IListSorter.class))).thenReturn(expected);
        int distinct = aggregator.distinct(deduplicator);

        assertEquals(4, distinct);
    }
}