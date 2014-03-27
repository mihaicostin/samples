package com.mc.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Options {

    public static void main(String[] args) {

        List<Double> numbers = Arrays.asList(10.0, null, 11.0, null, 34.0);

        numbers.stream().map(Optional::ofNullable).forEach(op -> {
            System.out.println("Present: " + op.isPresent() + ", " + op.orElse(0.0));
        });

        numbers.stream().map(Optional::ofNullable).map(op -> op.filter(el -> el % 2 == 0)).forEach(System.out::print);


    }
}
