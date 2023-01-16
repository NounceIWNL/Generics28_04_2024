package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        MagicBox magicBox = new MagicBox();

        magicBox.setObject(1); // integer
        System.out.println(magicBox.getObject());

        magicBox.setObject("2");
        System.out.println(magicBox.getObject());

        magicBox.setObject(new ArrayList<String>(Arrays.asList(new String("focus"), "pocus", "spell")));
        System.out.println(magicBox.getObject());

        // Тип объекта MagicBox (последннее использованное значение)
        Object object = magicBox.getObject();
        Class cl = object.getClass();
        System.out.println(cl);

        MagicBoxGeneric<Number> magicBoxGeneric = new MagicBoxGeneric<>();
        magicBoxGeneric.setObject(1.2);

        MagicBoxGeneric<MagicBoxGeneric<Number>> mbg1 = new MagicBoxGeneric<>();
        mbg1.setObject(magicBoxGeneric);
        System.out.println(mbg1.getObject().getObject());

    }
}

class MagicBox {
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}

class MagicBoxGeneric<T> {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

}
