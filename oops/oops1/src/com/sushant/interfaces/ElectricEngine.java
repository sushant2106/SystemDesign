package com.sushant.interfaces;

import com.sushant.properties.abstractdemo.Son;

import java.sql.SQLOutput;

public class ElectricEngine implements  Engine {

    @Override
    public void start() {
        System.out.println("Electric engine start");
    }

    @Override
    public void stop() {
        System.out.println("Electric engine stop");
    }

    @Override
    public void acc() {
        System.out.println("Electric engine accelerate");
    }
}
