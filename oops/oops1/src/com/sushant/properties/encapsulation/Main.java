package com.sushant.properties.encapsulation;

public class Main {

    public static void main(String[] args) {

        Student student=new Student();
        student.addSubject("Java");
        student.addSubject("SQL");

        System.out.println(student.hasSubject("Java"));
    }
}
