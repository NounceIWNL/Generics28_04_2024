package com.company.collections;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class StackDemo {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}

class Stack<E> {
    private List<E> list = new LinkedList<>();

    public void push(E obj) {
        list.add(obj);
    }

    public E pop() {
        if (list.size() == 0)
            throw new EmptyStackException();
        E obj = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return obj;
    }
}