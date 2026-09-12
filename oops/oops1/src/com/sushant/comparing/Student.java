package com.sushant.comparing;

import com.sushant.Testing.abstraction.PaymentService;

public class Student  implements Comparable<Student>{

    int rollNo;
    float marks;


    public Student(int rollNo,float marks){
        this.rollNo=rollNo;
        this.marks=marks;
    }

    @Override
    public String toString() {
        return rollNo + "";
    }

    @Override
    public int compareTo( Student other) {
        int diff=(int)(this.marks - other.marks);

        return diff;
    }
}
