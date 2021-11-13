package com.pb.gvozdev.hw7;

public class Atelier {

    static void  dressMan(Clothes[] clothes){
        for(Clothes cl : clothes)
            if(cl instanceof ManClothes)
                System.out.println("\nManClothes:\n"+((ManClothes) cl).dressMan());
    }
    static void  dressWomen(Clothes[] clothes){
        for(Clothes cl : clothes)
            if(cl instanceof WomenClothes) {
                System.out.println("\nWomenClothes:\n"+((WomenClothes) cl).dressWomen());
            }
    }

    public static void main(String[] args)  {

        Clothes pants = new Pants(Size.XXS,650,"black");
        Clothes tShirt = new Tshirt(Size.S,230.56,"green");
        Clothes skirt = new Skirt(Size.M,470,"white");
        Clothes tie = new Tie(Size.L,360,"grey");

        Clothes[] clothes = new Clothes[]{pants,tShirt,skirt,tie};

        dressMan(clothes);
        dressWomen(clothes);


    }
}
