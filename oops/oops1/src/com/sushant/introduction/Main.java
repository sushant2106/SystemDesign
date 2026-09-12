package com.sushant.introduction;

class Student {

    int rlno;
    String name;
    float marks = 90;

    Student() {
        //this is how you call a constructor from another constructor
        //internally : new Student(13,"default person",100.0f);
        this(13,"default person",100.0f);
//        this.rlno = 13;
//        this.name = "Sachin";
//        this.marks = 88.5f;
    }
    Student (int roll,String name,float marks){
        this.rlno=roll;
        this.name=name;
        this.marks=marks;
    }

    Student(Student other){
        this.name= other.name;
        this.rlno=other.rlno;
        this.marks=other.marks;
    }

}

    public class Main {

    public static void main(String[] args){

        Student  s1=new Student();

        System.out.println(s1.marks);

        Student random=new Student(s1);
        System.out.println("I am random reference var: " + random.marks);

        Student one= new Student();

        Student two=one;

        one.name="Something Something";

        System.out.println("This is two :" + two.name);



    }

}
