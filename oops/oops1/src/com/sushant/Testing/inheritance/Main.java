package com.sushant.Testing.inheritance;

//import static com.sushant.Testing.inheritance.Car.greetings;

public class Main {

    public static void main(String[] args) {
        BMW bmw=new BMW("horse power",8,"Blue");
//        bmw.getDetails();

        Car car=new BMW("Audi",8,"Blue");


        System.out.println(car.engine);
        car.getBaseClassDetails();

        Car.greetings();
    }
}
