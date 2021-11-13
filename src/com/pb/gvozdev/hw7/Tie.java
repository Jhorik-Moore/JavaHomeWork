package com.pb.gvozdev.hw7;

public class Tie extends Clothes implements ManClothes{

    String title = "Tie";

    Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public String dressMan() {
        return "\n"+"title: "+title+"\n"+"price: "+price+"\n"+"size: "+size+"\n"+"color: "+color+"\n"+"===========";
    }
}
