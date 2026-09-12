package com.sushant.Testing.inheritance;

public class Car {
     String engine;

    int wheel;

    Car(String engine,int wheel){
        super();
        this.engine=engine;
        this.wheel=wheel;
    }

    Car(){
        System.out.println("I am non parametrized constructor");
    }

    void getBaseClassDetails(){
        System.out.println("I am ParentClass");
    }

    static  void greetings(){
        System.out.println("Hey, I am Car Class.Greetings!");
    }



}
