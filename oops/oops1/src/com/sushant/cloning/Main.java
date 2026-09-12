package com.sushant.cloning;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)  throws  CloneNotSupportedException{

        Human sachin=new Human(34,"Sachin");

        //Human twin=new Human(sachin);


        Human twin=(Human)sachin.clone();

        System.out.println(twin.age + " " + twin.name);
        System.out.println(Arrays.toString(twin.arr));

        twin.arr[0]=100;

        System.out.println(Arrays.toString(sachin.arr));



    }
}
