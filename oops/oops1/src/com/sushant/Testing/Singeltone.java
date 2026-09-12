package com.sushant.Testing;

public class Singeltone {


    private Singeltone(){

    }

    private static Singeltone instance;

    public Singeltone getInstance(){
        if(instance==null){
            instance=new Singeltone();
        }
        return instance;
    }
}
