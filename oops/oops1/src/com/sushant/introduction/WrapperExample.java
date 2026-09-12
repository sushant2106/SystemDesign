package com.sushant.introduction;

class A{
    final int num=2;
    String name;

    public A(String name){
        this.name=name;
    }

    //how object get destroyed like how we have delete

//    @Override
//    protected  void finalize() throws Throwable{
//        System.out.println("Object is destroyed");
//    }



}

public class WrapperExample {

    static void swap(int a ,int b){
        int temp=a;
        a=b;
        b=temp;
    }

    public static void main(String[] args) {
        int a=10;
        int b=20;
        Integer num=45; //new Integer(45);
        //num is object, wrapper class

        swap(a,b);//in this case it will not swap
        //in java primitive datatype is pass by value which means it send 10 & 20 which is value

        //but when you pass Object it send reference:  Integer a,Integer b


        //when you declare any variable as final you must Initialize it
        //final int sum=2;

        //when a non primitive is final ,you can't reassign it.
        final A sachin=new A("Dr Sachin");


        sachin.name="sachh"; //this is allowed
        //sachin=new A("new object") is not allowed

//        A obj;
//
//        for(int i=0;i<10000000;i++){
//            obj=new  A();
//        }

    }
}
