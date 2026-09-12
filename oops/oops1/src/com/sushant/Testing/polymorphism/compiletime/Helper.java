package com.sushant.Testing.polymorphism.compiletime;

import com.sushant.access.A;

public class Helper  extends A {

    public Helper(int num,String name){
        super(num,name);
    }

    static  int multiply(int a,int b){
        return a*b;
    }


    static double multiply(double a,double b){
        return  a*b;
    }

//    public static void main(String[] args) {
//        Helper helper=new Helper(23,"Shyam");
//        System.out.println(helper.num);
//    }
}
