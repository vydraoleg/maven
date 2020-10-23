package com.fight.utils;


import com.fight.api.entities.Animal;

import java.io.*;

public class SerializationUtil {
    /**
     * Serialize animal to file
     *
     * @param animal
     * @param nFile
     * @return
     */
    public boolean serialize(Animal animal, String nFile) {

        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream(nFile))) {
            System.out.println(animal.toString());
            objectOutputStream.writeObject(animal);
            System.out.println(String.format("animal %s named %s was Serialized with strength %.2f ", animal.getNametype(), animal.getName(), animal.getStrength()));
        } catch (IOException e) {   // FileNotFoundException |
            System.out.println(String.format("Can not write file: file: %s", nFile));
            return false;
        }
        return true;
    }

    /**
     * Deserialize animal to file
     *
     * @param nFile
     * @return
     */
    public Animal deserialize(String nFile) {
        try (ObjectInputStream objectInputStream
                     = new ObjectInputStream(new FileInputStream(nFile))) {
            Animal animal = (Animal) objectInputStream.readObject();
            System.out.println(String.format("animal %s named %s was Deserialized with strength %.2f ", animal.getNametype(), animal.getName(), animal.getStrength()));
            return animal;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
