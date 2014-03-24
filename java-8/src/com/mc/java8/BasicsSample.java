package com.mc.java8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.function.Function;

public class BasicsSample {


    public static void main(String[] args) throws IOException, URISyntaxException {

        //some dates
        System.out.println(LocalTime.now());
        System.out.println(LocalDate.now());

        //previously know as System.currentTimeMillis
        System.out.println(Clock.systemDefaultZone().millis());

        //maybe better, so you won't depend on the machine's time-zone
        System.out.println(Clock.systemUTC().millis());

        //use a method ref to sort a list
        String[] values = new String[]{"1", "6", "2", "5", "3", "4"};
        Arrays.sort(values, String::compareTo);
        System.out.println(Arrays.toString(values));

        //a lambda expression would have worked just as well
        Arrays.sort(values, (s1, s2) -> s2.compareTo(s1));
        System.out.println(Arrays.toString(values));


        //some fun with functions
        Function<String, String> atr = (param) -> "Line: " + param;
        System.out.println(atr.apply("test string"));

        Arrays.asList("1", "2", "", "3", "   ", "  4", "6", "7").stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(atr)
                .forEach(System.out::println);


    }
}
