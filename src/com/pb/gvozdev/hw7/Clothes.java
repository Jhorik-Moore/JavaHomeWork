package com.pb.gvozdev.hw7;

public abstract class Clothes {

    Size size;
    double price;
    String color;

    Clothes(Size size, double price, String color){
        this.color = color;
        this.price = price;
        this.size = size;
    }

}
