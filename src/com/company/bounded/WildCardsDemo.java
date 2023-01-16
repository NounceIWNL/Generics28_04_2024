package com.company.bounded;

import java.util.ArrayList;
import java.util.List;

public class WildCardsDemo {
    public static void main(String[] args) {
        List<Sparrow> list1 = new ArrayList<>();
        list1.add(new Sparrow());
        list1.add(new Sparrow());
        System.out.println(list1);

        //print(list2);

        List<Animal> list2 = new ArrayList<>();
        list2.add(new Cat());
        list2.add(new Sparrow());
        print(list2);

        List<?> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list);

        List<? extends Animal> list3 = new ArrayList<>();
        list3.add(null);

    }

    // Upper WildCard
    public static void print2(List<? extends Animal> list){
        System.out.println(list);
    }

    // Lower WildCard
    public static void print3(List<? super Bird> list){
        System.out.println(list);
    }

    // Unbounded WildCard
    public static void print(List<?> list){
        System.out.println(list);
    }
}

