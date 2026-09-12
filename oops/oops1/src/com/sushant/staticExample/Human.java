package com.sushant.staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population;


    static  void message(){
        System.out.println("Hello World");

        //System.out.println(this.age);//can't use this over here
    }

    public Human(int age,String name,int salary,boolean married){
        this.age=age;
        this.name=name;
        this.salary=salary;
        this.married=married;
        Human.population+=1;
    }




}
