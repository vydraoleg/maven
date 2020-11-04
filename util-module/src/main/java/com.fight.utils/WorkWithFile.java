package com.fight.utils;


import com.fight.api.entities.Animal;
import com.fight.entities.Cat;
import com.fight.entities.Dog;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorkWithFile {
    private List<Animal> animalList;

    /**
     * Read file from operation system by path
     *
     * @return String file of name with path
     */
    private String readNameOfFile() {
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter file name: ");
            fileName = reader.readLine().trim();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            return fileName;
        }
    }

    /**
     * Read and return list of animal
     *
     * @return list of Animal
     */
    public List<Animal> animalFromFile() {
        String fileName = ".\\txt.txt"; //readNameOfFile();
        animalList = new ArrayList<Animal>();
        if (fileName.length() > 0) {
            try {
                List<String> lines =
                        Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
                for (String string : lines) {
                    if (string.length() > 3) {
                        String[] tempString = string.replaceAll(" ", "").split(",");
                        switch (tempString[0].trim()) {
                            case "Dog":
                                animalList.add(new Dog(tempString[1],
                                        Integer.parseInt(tempString[2]),
                                        Integer.parseInt(tempString[3]),
                                        Integer.parseInt(tempString[4])));
                                break;
                            case "Cat":
                                animalList.add(new Cat(tempString[1],
                                        Integer.parseInt(tempString[2]),
                                        Integer.parseInt(tempString[3]),
                                        Integer.parseInt(tempString[4])));
                                break;
                            default:
                                System.out.println(tempString[0]);
                                throw new IllegalStateException("Unexpected value: " + tempString[0]);
                        }
                    }
                }
            } catch (IOException e) {
                throw new IllegalStateException("Unexisting file: " + fileName);
            }
        }
        return animalList;
    }

    /**
     * Save string to file
     *
     * @param list     - string for saving
     * @param fileName name of file
     */
    public void saveToFile(String list, String fileName) {

        if (fileName.length() > 0) {
            try {
                Files.write(Paths.get(fileName), list.getBytes());
            } catch (IOException e) {
                throw new IllegalStateException("Unexisting file: " + fileName);
            }
        }
    }
    public void saveJSONToFile(Map<String, Integer> winners, String fileName) {

        if (fileName.length() > 0) {
            try {
                JSONObject json = new JSONObject(winners);
                Files.write(Paths.get(fileName),json.toString().getBytes());

            } catch (IOException e) {
                throw new IllegalStateException("Unexisting file: " + fileName);
            }
        }
    }

}
