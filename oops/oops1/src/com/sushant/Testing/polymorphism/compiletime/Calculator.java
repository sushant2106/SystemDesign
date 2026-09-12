package com.sushant.Testing.polymorphism.compiletime;

public class Calculator {

    int add(int num1, int num2) {
        return num1 + num2;
    }

    double add(double num1,double num2){
        return  num1+num2;
    }


    int add(int num1,int num2,int num3){
        return  num1 + num2 +num3;
    }

    void deposit(int amount){
        System.out.println("THe amount is " + amount);
    }
    void deposit(int amount, String description){
        System.out.println(amount + " " + description);
    }
    void deposit(double amount, String description, String currency){

    }

    void deposit(double amount, String description, String currency,String comment){

    }

    void calculateSalary(int basicSalary, int bonus){

    }

    void display(int x, String name) {
        System.out.println("int + String");
    }

    void display(String name, int x) {
        System.out.println("String + int");
    }

    void print(int x) {
        System.out.println("int");
    }

    void print(double x) {
        System.out.println("double");
    }

    void print(String x) {
        System.out.println("String");
    }

    void print(int x, double y) {
        System.out.println("int-double");
    }


    void show(long x) {
        System.out.println("long");
    }

    void show(Integer x) {
        System.out.println("Integer");
    }

    void show1(int...x){ //int[]x
        System.out.println("varargs");
    }




    public static void main(String[] args) {
       Calculator calculator=new Calculator();

//       calculator.display(10,"Ram");
//
//       calculator.print(10L);

        calculator.show(10);
    }

}
