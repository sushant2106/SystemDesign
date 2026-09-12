package com.sushant.properties.inheritance;

public class Box {

    private double l;
    double h;
    double w;

    double weight;

    static  void greetings(){
        System.out.println("Hey, I am Box Class.Greetings!");
    }

    Box(){
         this.l=-1;
         this.h=-1;
         this.w=-1;
    }

    Box (double side){
        //super(); this is referring to Object classes
        System.out.println("Box class Constructor ...Parent");
        this.w=side;
        this.l=side;
        this.h=side;

    }

     Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }
    Box(Box old){
        this.h=old.h;
        this.l= old.l;
        this.w= old.w;
    }

    public  void information(){
        System.out.println("Running the box ..with length:" + this.l);
    }


}
