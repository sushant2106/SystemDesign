package com.sushant.Testing.polymorphism.runtime;

public class NetBankingPayment extends Payment{

    @Override
    void pay() {
        System.out.println("Pay using Net Banking");
    }
}
