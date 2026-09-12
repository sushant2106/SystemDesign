package com.sushant.enumexample;

public class Basic {

    enum Week implements A{
        Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday;

        //these are enum constants
        //public static and final
        //since  its final you cann't create child enums

        //type is week

        Week(){
            System.out.println("Constructor called for "+this);
        }

        @Override
        public void hello() {
            System.out.println("Hello Enum");
        }

        // this is not public or protected ,only private or default
        //we don't want to create new object
        //this is not enum concept


        //internally: public static final Week Monday=new Week();


    }

    public static void main(String[] args) {

        Week week;
        week=Week.Monday;

        System.out.println(Week.valueOf("Monday"));
        for(Week day: Week.values()){
            System.out.println(day);
        }

//        System.out.println(week.ordinal());


    }
}
