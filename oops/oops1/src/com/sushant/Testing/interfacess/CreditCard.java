package com.sushant.Testing.interfacess;

public class CreditCard  implements Payment{

    @Override
    public void pay(){
        System.out.println("Payment using CreditCard");
    }
}
