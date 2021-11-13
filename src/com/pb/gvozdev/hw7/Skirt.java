package com.pb.gvozdev.hw7;

public class Skirt extends Clothes implements WomenClothes{

    String title = "Skirt";

    Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public String dressWomen() {
        return  "\n"+"title: "+title+"\n"+"price: "+price+"\n"+"size: "+size+"\n"+"color: "+color+"\n"+"===========";
    }
}
