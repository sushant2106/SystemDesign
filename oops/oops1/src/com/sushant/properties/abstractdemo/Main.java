package com.sushant.properties.abstractdemo;

public class Main {

    public static void main(String[] args) {
//
//        Parent son=new Son(21);

        Son son=new Son(21);
        son.career();



        System.out.println(son.age);

        Daughter daughter=new Daughter(20);

        daughter.career();

        //you can't create object of abstract class

        //but we can use it as reference variable


        Parent.hello();






    }
}
