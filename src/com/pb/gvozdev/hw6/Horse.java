package com.pb.gvozdev.hw6;

import java.util.Objects;

public class Horse extends Animal{


    String name = "Sweet";
    String breed = "Quarter";

    public Horse(String food, String location) {
        super(food, location);
    }

    @Override
    public void makeNoise(){
        System.out.println("Лошадь ржет с прохожих");
    }
    @Override
    public void eat(){
        System.out.println("Лошадь ест овёс");
    }
    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(food, horse.food) && Objects.equals(location, horse.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location);
    }
}
