package com.sushant.properties.encapsulation;

public class Person {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.age = age;
    }
}
