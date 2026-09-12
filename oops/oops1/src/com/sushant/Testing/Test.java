package com.sushant.Testing;

//import static com.sushant.Testing.Human.getHuman;
//import static com.sushant.Testing.Human.Other;

public class Test {
    public static void main(String[] args) {
        Human human=new Human(32,"Black");

        System.out.println(human.teeth);

        Human.getHuman();

//        Other =new Human.Other("")

        Human.Other other=new Human.Other("White");

        System.out.println(other.color);






    }
}
