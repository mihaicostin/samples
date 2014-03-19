package com.mc.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ListOp {


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

        //so far the output list has the same size as input list. the operation is performed per element.


    }

    private static List<Integer> process(List<Integer> input, Function<Integer, Integer> function) {
        List<Integer> result = new ArrayList<>();
        for (Integer el : input) {
            result.add(function.apply(el));
        }
        return result;
    }

}
