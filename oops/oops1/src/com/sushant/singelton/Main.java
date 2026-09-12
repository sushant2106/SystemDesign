package com.sushant.singelton;

public class Main {


    public static void main(String[] args) {

        Singletone obj1=Singletone.getInstance();

        Singletone obj2=Singletone.getInstance();

        Singletone obj3=Singletone.getInstance();

        //all 3 ref variable are pointing to just one object




    }
}
