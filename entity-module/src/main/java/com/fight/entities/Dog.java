package com.fight.entities;

import com.fight.api.entities.Animal;

public class Dog extends Animal {

    public Dog() {
        setNametype("Dog");
    }

    public Dog(String name, int age, int weight, double strenght) {
        this();
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
        this.setStrength(strenght);
    }

    @Override
    public void saySmth() {
        System.out.println("Bark!");
    }

}
