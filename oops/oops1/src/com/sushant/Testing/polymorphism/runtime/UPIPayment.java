package com.sushant.Testing.polymorphism.runtime;

public class UPIPayment extends  Payment{

    @Override
    void pay() {
        System.out.println("Pay using UPI");
    }
}
