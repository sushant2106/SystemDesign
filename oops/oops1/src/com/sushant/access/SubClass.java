package com.sushant.access;

public class SubClass extends A {

    public SubClass(int num,String name){
        super(num,name);
    }

    public static void main(String[] args) {

        SubClass obj=new SubClass(45,"Ram ji");

        System.out.println(obj.num);
    }


}


class SubSubClass extends  SubClass{

    public SubSubClass(int num,String name){
        super(num,name);

    }

    public static void main(String[] args) {
        SubSubClass subSubClass=new SubSubClass(45,"vishal");
        int n=subSubClass.num;
    }
}
