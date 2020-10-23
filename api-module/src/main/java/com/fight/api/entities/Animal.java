package com.fight.api.entities;

import java.io.Serializable;

public abstract class Animal implements Serializable {

    private String name;
    protected int age;
    protected int weight;
    protected double strength;
    protected String nametype;   // Name of type

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getNametype() {
        return nametype;
    }

    public void setNametype(String nameType) {
        this.nametype = nameType;
    }

    public void saySmth() {
        System.out.println("say something");
    }

    public String toString() {
        return getNametype() + "info - name:" + getName() + " age: " + getAge() + " strength: " + getStrength();
    }
}
