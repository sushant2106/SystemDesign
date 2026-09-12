package com.sushant.properties.inheritance;

public class BoxWeight  extends Box{

    double weight;


//    @Override  static Method can't be override
//    static  void greetings(){
//        System.out.println("Hey, I am Box Class.Greetings!");
//    }
    //static method can be inherited but can't be overridden
    //bz the one main class is going to call
    //override depends on object and static doesn't depends upon object
    //Hence Static Method can't be overridden

    public BoxWeight(){
        this.weight=-1;
    }

    BoxWeight(BoxWeight other){
        super(other);
        weight=other.weight;
    }

    BoxWeight(double side,double weight){
        super(side);
        this.weight=weight;

    }


    public  BoxWeight(double l,double h,double w,double weight){
        super(l,h,w); //call the parent class constructor
        //used to initialise values present in parent class
        this.weight=weight;



        //System.out.println(super.weight); //if super class also have
        //weight class


    }

}
