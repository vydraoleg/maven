package com.fight.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalServiceTest {

        @DisplayName("Test Cat setAge()")
        @Test
        void testSetAge(){
            Cat cat = new Cat();
            cat.setAge(5);
            assertEquals(5,cat.getAge());
        }
        @DisplayName("Test Cat setAge()")
        @Test
        void testSetName(){
            Cat cat = new Cat();
            cat.setName("Vaska");
            assertEquals("Vaska",cat.getName());
        }

        @DisplayName("Test Cat getAge()")
        @Test
        void testGetAge(){
            Cat cat = new Cat(5);
            assertEquals(5,cat.getAge());
        }
        @DisplayName("Test Cat getAge()")
        @Test
        void testGetName(){
            Cat cat = new Cat();
            assertEquals("Vaska",cat.getName());
        }

    }
