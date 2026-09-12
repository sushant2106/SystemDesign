package com.sushant.Testing.abstraction;

public class Cards extends  Payment{


    Cards(){
        super(2300);
    }
    @Override
    void pay(){
        System.out.println("I am a Card Class");
    }

}
