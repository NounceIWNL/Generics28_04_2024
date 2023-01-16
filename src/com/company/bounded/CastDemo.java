package com.company.bounded;

import java.util.ArrayList;
import java.util.List;

public class CastDemo {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(1);
        list.add(new String("2"));
        list.add(new Pigeon());

        for (Object o : list) {
            System.out.println(o);
            String s;
            if (o instanceof java.lang.String) {
                s = ((String) o);
                System.out.println(s);
            }
        }
    }
}
