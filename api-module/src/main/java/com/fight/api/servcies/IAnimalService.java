package com.fight.api.servcies;


import com.fight.api.entities.Animal;

import java.util.List;

public interface IAnimalService {

    List<Animal> getAnimals();

    void addAnimal(Animal animal);

    Animal getByName(String name);

    void updateAnimalStrength(String name, int strength);

}
