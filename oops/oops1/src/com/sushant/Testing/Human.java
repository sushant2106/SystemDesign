package com.sushant.Testing;

public class Human {
    int teeth;
    String hairColour;

    static int count=0;

    static {
        count+=1;
    }


    Human(int teeth,String hairColour){
        this.teeth=teeth;
        this.hairColour=hairColour;
    }

    String getCity(){

        return "Patna";
    }

    public static class Other{
        String color;

        Other(String color){
            this.color=color;

        }


    }

    static void getHuman(){
        System.out.println("I am from India");
    }

    public static void main(String[] args) {
        Other other=new Other("White");

         getHuman();

        System.out.println(other.color);
    }


}
