package com.fight.dao;

import com.fight.api.dao.IAnimalDao;
import com.fight.api.exception.AnimalNotFoundException;
import com.fight.api.entities.Animal;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalDao implements IAnimalDao {

    private List<Animal> animals = new ArrayList<>();

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Add animal to list
     * @param animal
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getNametype() + " was added, " + animal.toString());
    }

    /**
     * Return animal by name
     * @param name
     * @return
     * @throws AnimalNotFoundException
     */
    public Animal getByName(String name) throws AnimalNotFoundException {
        Optional<Animal> optionalAnimal =
                animals.stream()
                        .filter(x -> x.getName().equals(name))
                        .findFirst();
        Animal animal = optionalAnimal.orElseThrow(() -> new AnimalNotFoundException());

        return animal;
    }

    /**
     * Update strength to Animal
     * @param name
     * @param strength
     * @throws AnimalNotFoundException
     */
    public void updateAnimalStrength(String name, int strength) throws AnimalNotFoundException  {
        Animal animal = this.getByName(name);
        animal.setStrength(strength);
        System.out.println(animal.getNametype()+" was updated, " + animal.toString());
    }

    /**
     * Setter
     * @param animals
     */
    public void setAnimal(List<Animal> animals) {
        this.animals = animals;
    }

}
