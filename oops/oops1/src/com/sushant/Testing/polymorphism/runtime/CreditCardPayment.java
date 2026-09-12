package com.sushant.Testing.polymorphism.runtime;

public class CreditCardPayment extends Payment{

    @Override
    void pay() {
        System.out.println("Pay using credit card");
    }

}
