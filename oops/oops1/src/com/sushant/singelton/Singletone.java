package com.sushant.singelton;

public class Singletone {

//    private int num=0;


     private Singletone(){

    }

    private static Singletone instance;

    public static Singletone getInstance(){
     //check weather one object is created or not

        if(instance == null){
            instance=new Singletone();
        }

        return  instance;

    }

}
