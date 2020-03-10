package com.aor.numbers;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListFiltererTest {
    @Test
    public void filter() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(2);
        list.add(-3);
        list.add(4);
        list.add(-5);

        ListFilterer filterer = new ListFilterer(list);

        PositiveFilter filterPositive = Mockito.mock(PositiveFilter.class);
        Mockito.when(filterPositive.accept(-1)).thenReturn(false);
        Mockito.when(filterPositive.accept(2)).thenReturn(true);
        Mockito.when(filterPositive.accept(-3)).thenReturn(false);
        Mockito.when(filterPositive.accept(4)).thenReturn(true);
        Mockito.when(filterPositive.accept(-5)).thenReturn(false);

        DivisibleByFilter filterDivision = Mockito.mock(DivisibleByFilter.class);
        Mockito.when(filterDivision.accept(-1)).thenReturn(false);
        Mockito.when(filterDivision.accept(2)).thenReturn(true);
        Mockito.when(filterDivision.accept(-3)).thenReturn(false);
        Mockito.when(filterDivision.accept(4)).thenReturn(true);
        Mockito.when(filterDivision.accept(-5)).thenReturn(false);

        List<Integer> positives = filterer.filter(filterPositive);
        List<Integer> divisibles = filterer.filter(filterDivision);

        List<Integer> res = new ArrayList<>();
        res.add(2);
        res.add(4);


        assertEquals(positives, res);
        assertEquals(divisibles, res);
    }
}
