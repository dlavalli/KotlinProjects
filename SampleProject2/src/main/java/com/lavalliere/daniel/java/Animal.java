package com.lavalliere.daniel.java;

public class Animal {
    private final String name;
    private final String kind;
    private Integer weight;

    public Animal(String name, String kind, Integer weight) {
        this.name = name;
        this.kind = kind;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String show() {
        return String.join(" ", name,"is a", kind, "and weighs", weight.toString(), "lbs.");
    }
}
