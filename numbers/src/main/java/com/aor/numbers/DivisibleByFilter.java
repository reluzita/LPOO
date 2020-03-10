package com.aor.numbers;

public class DivisibleByFilter implements IListFilter{
    private Integer num;
    public DivisibleByFilter(Integer num) {
        this.num = num;
    }
    @Override
    public boolean accept(Integer number) {
        if (num == 0)
            return false;
        return (number % num) == 0;
    }
}
