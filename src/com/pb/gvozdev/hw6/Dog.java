package com.pb.gvozdev.hw6;

import java.util.Objects;

public class Dog extends Animal{

    String name = "Chuck";
    String breed = "doberman";

    public Dog(String food, String location) {
        super(food, location);
    }

    @Override
    public void makeNoise(){
        System.out.println("Собака лает на прохожих");
    }

    @Override
    public void eat(){
        System.out.println("Собака ест Pedigree");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(food, dog.food) && Objects.equals(location, dog.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location);
    }
}
