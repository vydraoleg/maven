package com.fight.api.dao;


import com.fight.api.exception.AnimalNotFoundException;
import com.fight.api.entities.Animal;

import java.sql.SQLException;
import java.util.List;

public interface IAnimalDao {

    List<Animal> getAnimals();

    void readAnimals() throws SQLException;

    void addAnimal(Animal animal);

    Animal getByName(String name) throws AnimalNotFoundException;

    void updateAnimalStrength(String name, int strength) throws AnimalNotFoundException;
}
