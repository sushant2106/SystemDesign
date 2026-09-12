package com.sushant.properties.inheritance;

public class BoxColor extends BoxWeight{

    String color;


    BoxColor(double side,double weight,String color){
        super(side,weight);
        this.color=color;
    }




}
