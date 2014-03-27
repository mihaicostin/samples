package com.mc.java8;

public class Defaults {


    interface Ga {
        default void fun() {
            System.out.println("This is fun");
        }
    }

    interface Gu {
        default void fun() {
            System.out.println("Not so much fun");
        }

        static int number() {
            return 10;
        }
    }


    class GuGu implements Ga, Gu {
        public void fun() {
            Gu.super.fun();
        }

    }


    public static void main(String[] args) {
        //System.out.println(GuGu.number());
    }

}
