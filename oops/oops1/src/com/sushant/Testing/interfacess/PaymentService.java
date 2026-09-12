package com.sushant.Testing.interfacess;

public class PaymentService {


    void processPayment(Payment payment){
        payment.pay();
    }

    public static void main(String[] args) {

//         PaymentService paymentService=new PaymentService();
//
//         paymentService.processPayment(new UPI());

         Payment payment= new UPI();

        payment.pay();

        System.out.println(Payment.num);


    }
}
