package com.fight.dao;

import com.fight.api.dao.IAnimalDao;
import com.fight.api.exception.AnimalNotFoundException;
import com.fight.api.entities.Animal;
import com.fight.entities.Cat;
import com.fight.entities.Dog;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*


        }

*/
public class AnimalDao implements IAnimalDao {

    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/itacademia?useUnicode=true&serverTimezone=UTC";
    private Connection connection = null;

    private List<Animal> animals = new ArrayList<>();

    public void AnimalDao() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
    }

    public void CloseAnimalDao() throws SQLException {
        connection.close();
    }
    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Read animals from database
     * @param
     * @return List<Animal>  read from database from table animals
     */
    @Override
    public void readAnimals() throws SQLException{
        if(connection == null)  AnimalDao();
        Statement statement = connection.createStatement();
        String sql= "SELECT atype,name,age, weight,strength FROM animals";

        ResultSet resultSet = statement.executeQuery(sql);
        // Delete previous animals
//        animals = new ArrayList<>();
        String str1;
        while(resultSet.next()){
            str1 = resultSet.getString("atype").trim();
            switch (str1) {
                case "Dog":
                    animals.add(new Dog(resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getInt("weight"),
                            resultSet.getInt("strength")));
                    break;
                case "Cat":
                    animals.add(new Cat(resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getInt("weight"),
                            resultSet.getInt("strength")));
                    break;
                default:
                    System.out.println("Unexpected value: " + resultSet.getString("atype"));
                    throw new IllegalStateException("Unexpected value: " + resultSet.getString("atype"));
            }
        }
        resultSet.close();
        statement.close();
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
