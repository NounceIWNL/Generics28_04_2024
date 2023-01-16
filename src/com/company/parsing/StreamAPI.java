package com.company.parsing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamAPI {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(genNatural(1, 9)));

        System.out.println(Arrays.toString(genEven(1, 9)));

        int[] arr = genNatural(1, 9);
        int[] arr2 = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .toArray();

        System.out.println(Arrays.toString(arr2));

        System.out.println(Arrays.stream(arr).sum());

        System.out.println(Arrays.stream(arr).count());

        System.out.println(Arrays.toString(genRandom(1, 10, 10)));

        System.out.println(Arrays.toString(gen3_5_11()));
    }

    static int[] genNatural(int min, int max) {
        return IntStream
                .range(min, max + 1)
                .toArray();
    }

    static int[] genEven(int min, int max) {
        return IntStream
                .range(min, max + 1)
                .filter(n -> n % 2 == 1)
                .toArray();
    }

    static int[] genRandom(int min, int max, int count) {
        Random random = new Random();
        return IntStream
                .generate(() -> random.nextInt(max - min + 1) + min)
                .limit(count)
                .toArray();
    }

    static int[] gen3_5_11() {
        return IntStream
                .range(1, 1001)
                .filter(n -> n % 3 == 0 || n % 5 == 0 || n % 11 == 0)
                .toArray();
    }
}
