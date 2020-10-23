package com.fight.api.dao;


import com.fight.api.exception.AnimalNotFoundException;
import com.fight.api.entities.Animal;

import java.util.List;

public interface IAnimalDao {

    List<Animal> getAnimals();

    void addAnimal(Animal animal);

    Animal getByName(String name) throws AnimalNotFoundException;

    void updateAnimalStrength(String name, int strength) throws AnimalNotFoundException;
}
