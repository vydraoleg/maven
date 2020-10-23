package com.fight.services;


import com.fight.api.dao.IAnimalDao;
import com.fight.api.exception.AnimalNotFoundException;
import com.fight.api.servcies.IAnimalService;
import com.fight.dao.AnimalDao;
import com.fight.api.entities.Animal;
import com.fight.entities.Cat;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class AnimalService implements IAnimalService {

    IAnimalDao animalDao ;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Override
    public void readAnimals() {
        animalDao = new AnimalDao();
        try {
            animalDao.readAnimals();
        } catch(SQLException e) {
            System.out.println("Can not read Animals from DB !");
        }
    }
    @Override
    public List<Animal> getAnimals() {
        return animalDao.getAnimals();
    }

    @Override
    public void addAnimal(Animal animal) {
        animalDao.addAnimal(animal);
    }

    @Override
    public Animal getByName(String name) {
        try {
            return animalDao.getByName(name);
        } catch (AnimalNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println(LocalDateTime.now().format(format) + " Exception caught, AnimalNotFoundException!");
            return null;
        }
    }

    @Override
    public void updateAnimalStrength(String name, int strength) {
        try {
            animalDao.updateAnimalStrength(name, strength);
        } catch (AnimalNotFoundException e) {
            Animal an = new Cat();
            an.setName(name);
            an.setStrength(strength);
            this.addAnimal(an);
        }
    }

}
