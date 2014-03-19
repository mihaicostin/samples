package com.mc.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListOp {

    private static <T> List<T> process(List<T> input, Function<T, T> function) {
        List<T> result = new ArrayList<>();
        for (T el : input) {
            result.add(function.apply(el));
        }
        return result;
    }

    public static void main(String[] args) {

        //process the input list and generate a new list as result.
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);


        //using a process method and lambda
        List<Integer> output = process(input, e -> e + 1);
        System.out.println(output);


        //using a Function instance
        output = process(input, new IncrementOddOperation());
        System.out.println(output);


        //using streams and map.
        output.clear();
        input.stream().map(e -> e + 1).forEach(output::add);
        System.out.println(output);

        //or using also the provided collector...
        output = input.stream().map(e -> e + 1).collect(Collectors.toList());
        System.out.println(output);



        //so far the output list has the same size as input list. the operation is performed per element.


        //using filter and map to process only part of the input list.
        output = input.stream().filter(e -> e < 5).map(e -> e + 10).collect(Collectors.toList());
        System.out.println(output);


    }


}
