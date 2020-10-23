package com.fight.main;


import com.fight.api.entities.Animal;
import com.fight.api.servcies.IAnimalService;
import com.fight.services.AnimalService;
import com.fight.services.Fight;

public class Main {

    public static void main(String[] args) {

        IAnimalService animalService = new AnimalService();

        // Read Animal Fighter from DB and add to animalService
        animalService.readAnimals();
        if (!animalService.getAnimals().isEmpty()) {
            // print list of animals from animalService
            animalService.getAnimals()
                    .stream()
                    .peek(an -> System.out.print(an.getNametype() + "'s name is  " + an.getName() + " strength is " + an.getStrength() + " says "))
                    .forEach(Animal::saySmth);

            // Fight
            new Fight(animalService);
        } else {
            System.out.println("There is not list of fighter!");
        }
    }
}