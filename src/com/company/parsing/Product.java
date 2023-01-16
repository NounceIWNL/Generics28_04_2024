package com.company.parsing;

public class Product {
    private String name;
    private double calories; //В пересчете на 100 г
    private double proteins;
    private double fats;
    private double carbohydrates;

    public Product(){}

    //Code - generate - constructor (select all fields)
    public Product(String name, double calories, double proteins, double fats, double carbohydrates) {

        this.name
                = name;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }
}
