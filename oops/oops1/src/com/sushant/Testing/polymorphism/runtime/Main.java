package com.sushant.Testing.polymorphism.runtime;

public class Main {

    public static void main(String[] args) {
        Payment payment;

        payment = new CreditCardPayment();
        payment.pay();

        payment = new UPIPayment();
        payment.pay();

        payment = new NetBankingPayment();
        payment.pay();
    }
}
