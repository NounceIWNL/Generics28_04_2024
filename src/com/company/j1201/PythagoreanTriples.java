package com.company.j1201;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {
    public static void main(String[] args) {
        List<Triple> triples =
                IntStream.iterate(1, i -> i + 1)
                        .mapToObj(i -> Stream.iterate(1, j -> j + 1)
                        .limit(20)
                            .filter(j->Math.abs(Math.sqrt(i*i+j*j)-(int)Math.sqrt(i*i+j*j))<1e-10)
                            .map(j->new Triple(i<j?i:j,j>i?j:i,i*i+j*j))
                             )
                            .flatMap(Function.identity())
                            .distinct()
                            .limit(20)
                            .collect(Collectors.toList());

        for (Triple t : triples) {
            System.out.println(t);
        }
    }
}

class Triple {
    int arr[];

    public Triple(int a, int b, int c) {
        this.arr = new int[]{a, b, c};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple triple = (Triple) o;
        return Arrays.equals(arr, triple.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    @Override
    public String toString() {
        return "Triple{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
