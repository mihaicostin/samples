package com.mc.java8;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsSample {

    private static class Pair<T> {
        public final T a;
        public final T b;

        public Pair(T a, T b) {
            this.a = a;
            this.b = b;
        }
    }


    public static void main(String[] args) {

        Stream<Integer> stream = Stream.generate(() -> 1);
        //take the first 100 elements of the stream and print them out.
        stream.limit(100).forEach(System.out::print);


        stream = Stream.iterate(0, e -> e + 1);
        stream.limit(10).forEach(System.out::println);


        System.out.println("And now, Fibonacci... ");
        Stream.iterate(new Pair<>(0, 1), pair -> new Pair<>(pair.b, pair.a + pair.b))
                .map(pair -> pair.b)
                .limit(15)
                .forEach(System.out::println);

        //don't try this out.
        //System.out.println(fibStream.count());

        //generate numbers and split the first 20 into odd and even, then print them out.
        Stream.iterate(0, e -> e + 1).limit(20).
                collect(Collectors.groupingBy(e -> {
                    if (e % 2 == 0) return "even";
                    else return "odd";
                })).forEach((k, v) -> System.out.println(k + " : " + v));

    }
}
