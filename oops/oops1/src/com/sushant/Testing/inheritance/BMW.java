package com.sushant.Testing.inheritance;

public class BMW extends Car {

    String color;


    BMW(String engine,int wheel,String color){
//        super(engine,wheel);
        super.engine=engine;
        super.wheel=wheel;
        this.color=color;

    }

    void getDetails(){
        System.out.println("Engine: " + this.engine + " wheel: " +this.wheel);
        System.out.println("Color: " + this.color);
    }


    static  void greetings(){
        System.out.println("Hey, I am BMW Class.Greetings!");
    }
}
