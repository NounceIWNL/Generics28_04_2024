package com.company.j1201;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Mirror {
    public static void main(String[] args) {
        int[] arr = IntStream.iterate(1, i -> i + 1)
                .filter(i->isPrime(i) && isPrime(reverse(i)))
                .skip(5)
                .limit(10)
                .toArray();

        System.out.println(Arrays.toString(arr));
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

    private static int reverse(int number){
        return Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
    }
}
