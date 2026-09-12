package com.sushant.access;

public class A {

    protected int num;
    String name;
    int[] arr;

    public  int getNum(){
        return  num;
    }

    public void setName(int num){
        this.num=num;
    }

    public  A(int num,String name){
        this.num=num;
        this.name=name;
        this.arr= new int[num];
    }
}
