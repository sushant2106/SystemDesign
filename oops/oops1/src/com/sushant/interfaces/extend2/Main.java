package com.sushant.interfaces.extend2;

import java.util.MissingFormatArgumentException;

public class Main implements  A,B {

    @Override
    public void greet() {

    }

//    @Override
//    public void fun() {
//
//    }

    public static void main(String[] args) {
        Main obj=new Main();

        A.greeting();

    }
}
