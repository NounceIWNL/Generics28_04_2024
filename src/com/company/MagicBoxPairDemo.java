package com.company;

public class MagicBoxPairDemo {
    public static void main(String[] args) {

        MagicBoxPair<Integer, String> magicBoxPair = new MagicBoxPair<>(1, "2");


    }
}

class MagicBoxPair<T, U> {

    private T first;
    private U second;

    public MagicBoxPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

}