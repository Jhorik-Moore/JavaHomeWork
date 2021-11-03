package com.pb.gvozdev.hw6;

public class Animal {

     public  String food, location;

     public Animal(String food, String location) {
          this.food = food;
          this.location = location;
     }

     public  void makeNoise(){};
     public  void eat(){};

     public static void sleep(Animal animal){
         System.out.println(animal+" спит");
     };
}
