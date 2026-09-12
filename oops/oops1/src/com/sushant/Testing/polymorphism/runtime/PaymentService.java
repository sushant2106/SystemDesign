package com.sushant.Testing.polymorphism.runtime;

public class PaymentService {

    void processPayment(Payment payment) {
        payment.pay();
    }

    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.processPayment(new CreditCardPayment());

        service.processPayment(new UPIPayment());

        service.processPayment(new NetBankingPayment());
    }
}
