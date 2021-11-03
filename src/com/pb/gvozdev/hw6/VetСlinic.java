package com.pb.gvozdev.hw6;


import java.lang.reflect.Constructor;

import static com.pb.gvozdev.hw6.Animal.sleep;

public class VetСlinic {

    static Animal dog = new Dog("Pedigree","Dnepr");
    static Animal cat = new Cat("Whiskas","Kyiv");
    static Animal horse = new Horse("Oats","Lviv");


    public static void main(String[] args) throws Exception {

        Animal[] animals = {dog, cat, horse};

        System.out.println("МЕТОДЫ:\n");
        dog.eat();
        cat.makeNoise();
        sleep(horse);
        System.out.println("\nК ВЕТЕРИНАРУ:\n");

        for (Animal animal : animals) {
           Class<?> v = Class.forName("com.pb.gvozdev.hw6.Veterinarian");
            Constructor<?> constructor = v.getConstructor();
            Object obj = constructor.newInstance();
                ((Veterinarian) obj).treatAnimal(animal);
        }


    }
}