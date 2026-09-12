package com.sushant.Testing.abstraction;

abstract class Payment {
    static String bank="SBI";
    abstract void pay();
    int num;

    Payment(){

    }
    Payment(int num){
        this.num=num;
    }

    static class A{
        int num=2;
        String name;
        int number;

        A(){

            this("ram ji",3);
        }

        A(String name,int num){
            this.name=name;
            this.num=num;
        }
    }


    public void add(){
        System.out.println("I am add");
    }
}

