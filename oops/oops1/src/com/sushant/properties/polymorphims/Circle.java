package com.sushant.properties.polymorphims;

public class Circle extends Shapes{

    //this will run when obj  of circle is created
    //hence it is overriding the parent method

    @Override  //this is called Annotation
   void area(){
       System.out.println("area of circle is pi * r * r");
   }

}
