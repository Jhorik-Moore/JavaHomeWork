package com.pb.gvozdev.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{

    String title = "T-shirt";

    Tshirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public String dressMan() {
        return "\n"+"title: "+title+"\n"+"price: "+price+"\n"+"size: "+size+"\n"+"color: "+color+"\n"+"===========";
    }
    @Override
    public String dressWomen() {
        return "\n"+"title: "+title+"\n"+"price: "+price+"\n"+"size: "+size+"\n"+"color: "+color+"\n"+"===========";
    }
}
