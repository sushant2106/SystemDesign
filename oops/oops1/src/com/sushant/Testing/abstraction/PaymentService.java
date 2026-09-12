package com.sushant.Testing.abstraction;

import javax.swing.plaf.PanelUI;

public class PaymentService {

    Payment payment;

    PaymentService(){
        payment=new UPI();
    }


    PaymentService(Payment payment){
        this.payment=payment;
    }

    public void doPayment(){
        payment.pay();
    }

    public static void main(String[] args) {
        PaymentService paymentService=new PaymentService();

        paymentService.doPayment();


    }

}
