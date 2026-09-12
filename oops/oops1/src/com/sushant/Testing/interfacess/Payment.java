package com.sushant.Testing.interfacess;

public interface Payment {
     public static final int num=2;

     public abstract void  pay();

     default void receipt(){
         System.out.println("Generating receipt");
     }

     static void validate(){
         System.out.println("Validating payment");
     }

    private void validate3() {
        System.out.println("Validating...");
    }


}
