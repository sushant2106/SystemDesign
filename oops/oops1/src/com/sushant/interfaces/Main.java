package com.sushant.interfaces;

public class Main {

    public static void main(String[] args) {


        Car car=new Car();
//        car.acc();
//        car.start();
//        car.stop();


        Engine engine=new Car(); // upcasting allowed
     //what you can access depends on reference variable

     //what method you are going to call depend upon Object

//
//
//        Media carMedia=new Car();
//
//        carMedia.stop();

        NiceCar niceCar=new NiceCar(new ElectricEngine());

        niceCar.start();
        niceCar.startMusic();
        niceCar.stop();

        niceCar.upgradeEngine(new ElectricEngine());

        niceCar.start();



    }
}
