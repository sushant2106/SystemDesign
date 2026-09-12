package com.sushant.properties.abstractdemo;

//because we want inheritance  so final abstract class is not allowed
public abstract class Parent {

//    abstract  void career(String name);
//
//    abstract void partner(String name,int age);

    int age;

    static String country;

    static {
        Parent.country="INDIA";

    }
    final int value=289;
    //constructor of abstract class is allowed

//    Parent(int age){
//        this.age=age;
//    }

    static void hello(){
        System.out.println("I am abstract class static method");
    }

    void normal(){
        System.out.println("I am normal method");
    }
    //abstract  Parent(); //not allowed
    abstract  void career();

    abstract void partner();
}
