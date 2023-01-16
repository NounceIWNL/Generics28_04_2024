package com.company.j1201;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Mersenn {
    public static void main(String[] args) {
        int[] arr = IntStream.iterate(1, i -> i + 1)
                .map(i -> (int) (Math.pow(2, i) - 1))
                .filter(i->isPrime(i))
                .limit(8)
                .toArray();

        System.out.println(Arrays.toString(arr));
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
