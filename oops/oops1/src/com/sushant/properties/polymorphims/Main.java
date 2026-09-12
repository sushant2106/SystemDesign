package com.sushant.properties.polymorphims;

public class Main {

    public static void main(String[] args) {

        Shapes shape=new Circle();//bz its getting override
       //whatever type of object is that type is only going to be used
        //type of Method in overriding is called depends upon what type of object is

        //but the reference variable will decide which type of variable and access
        //is going to access depends upon reference variable

        shape.area();

        Circle circle=new Circle();

        circle.area();




    }

}
