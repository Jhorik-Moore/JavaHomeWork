package com.pb.gvozdev.hw6;

import java.util.Objects;

public class Cat extends Animal{

    String name = "Tom";
    String breed = "Siberian";

    public Cat(String food, String location) {
        super(food, location);
    }

    @Override
    public void makeNoise(){
        System.out.println("Кот шипит на прохожих");
    }
    @Override
    public void eat(){
        System.out.println("Кот ест Whiskas");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(food, cat.food) && Objects.equals(location, cat.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
