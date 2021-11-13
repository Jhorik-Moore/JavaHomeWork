package com.pb.gvozdev.hw7;

public enum Size {

    L("L",40),
    M("M",38),
    S("S",36),
    XS("XS",34),
    XXS("XXS",32);

    private final String description;
    private final Integer euroSize;

     String getDescription(Size s){
         if(s.equals(XXS))
         return "Детский размер";
         else return "Взрослый размер";
     }

    Integer getEuroSize(Size s){
         if(s.equals(XXS))
             return 32;
         else if(s.equals(XS))
             return 34;
         else if(s.equals(S))
             return 36;
         else if(s.equals(M))
             return 38;
         else if(s.equals(L))
             return 40;
         return null;
    }

    Size(String description, Integer euroSize){
         this.description = description;
         this.euroSize = euroSize;
    }
}
