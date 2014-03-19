package com.mc.java8;

import java.util.function.Function;

public class IncrementOddOperation implements Function<Integer, Integer> {
    public boolean isOdd(Integer el) {
        return el % 2 == 0;
    }

    @Override
    public Integer apply(Integer integer) {
        if (isOdd(integer)) return integer + 1;
        else return integer;
    }
}
