package com.sushant.staticExample;


//outside class can't be static
//only inner class can be static

//class Test{
//    static  String name;
//
//    public Test(String name){
//        Test.name=name;
//    }
//
//}

public class InnerClasses {

    //Making Test as static mean .it not dependent on the object of
    //InnerClasses

    static class Test{
       String name;

       public Test(String name){
           this.name=name;
       }

    }

    static class Test2{
        static  String naam;

        public  Test2(String naam){
            Test2.naam=naam;
        }

    }

    public static void main(String[] args) {

        Test a=new Test("Sachin");
        Test b=new Test("RamJi");

        System.out.println(a.name);
        System.out.println(b.name);

        Test2 c= new Test2("delhi");
        Test2 d= new Test2("banglore");

        System.out.println(Test2.naam);
        System.out.println(Test2.naam);









    }
}
