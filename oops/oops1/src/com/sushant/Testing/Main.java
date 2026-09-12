package com.sushant.Testing;


class  Student{

    int rlno;
    String name;
    float marks = 90;
    static int object_count=0;
    static  int b;

    static {
        System.out.println("I am in static block");
        b=2;
    }


    Student(){

        this(23,"Sachin",302.2f);
    }

    Student(int rlno,String name,float marks){
        this.rlno=rlno;
        this.name=name;
        this.marks=marks;
        Student.object_count+=1;
    }

    static  void message(){
        System.out.println("Hello World I am Static..");

        System.out.println(Student.object_count);
    }
}
public class Main {

    public static void main(String[] args) {

        System.out.println("Value of b before Any Object creation :" + Student.b);

        Student s1=new Student();

        System.out.println(s1.rlno + " " + s1.name + " " + s1.marks);

        System.out.println("Value of b After first Object creation :" + Student.b);

        Student s2=s1;

        System.out.println(s2.name);

        Student s3=new Student();

        Student.b+=10;

        System.out.println("This is static " + Student.object_count);

        Student.message();

        System.out.println("Value of b After Second Object creation :" + Student.b);

    }


}
