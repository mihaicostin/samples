package com.mc.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SimpleApp {


    public static void main(String[] args) throws IOException {


        System.out.println(LocalTime.now());
        System.out.println(LocalDate.now());

        System.out.println(Clock.systemDefaultZone().millis());

        String[] values = new String[]{"1","6","2","5","3","4"};

        Arrays.sort(values, String::compareTo);


        System.out.println(Arrays.toString(values));



        Function<String, String> atr = (param) -> "Line: " + param;

        System.out.println(atr.apply("test string"));

        Files.lines(Paths.get("/Users/mcostin/users.txt"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(atr)
                .forEach(System.out::println);







    }
}
