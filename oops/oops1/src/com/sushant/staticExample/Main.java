package com.sushant.staticExample;

public class Main {

    //we know something that which is not static ,belongs to object
    void greeting(){
       // fun(); //here its allow
        System.out.println("Hello World");
    }

    //this is not dependent object
    static void fun(){

      // greeting(); // you can't use this bz it requires an instance
        //but the function you are using it in does not depend on instances

        //how it works

        //you can't access non-static stuff without referencing their instance in
        //a static context

        //hence I am referencing it
        Main obj=new Main();
        obj.greeting();
    }

    void fun2(){
        greeting();
    }

    public  static void main(String[] args){

//        Human sachin=new Human(25,"Sachin",50000,false);
//
//        Human vishal=new Human(26,"Vishal",60000,true);
//
//        Human shantnu=new Human(26,"Shantnu",50000,false);
//
//        System.out.println(sachin.name);
//
//        System.out.println(Human.population);
//        System.out.println(Human.population);
//        System.out.println(Human.population);

        Main funn=new Main();
//        greeting();
       funn.fun2();



    }
}
