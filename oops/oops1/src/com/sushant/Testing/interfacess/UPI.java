package com.sushant.Testing.interfacess;

public class UPI implements  Payment{

    public String bank="SBI";
    @Override
    public void pay(){
        System.out.println("Paying through upi");
    }
}
