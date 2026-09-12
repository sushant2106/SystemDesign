package com.sushant.exceptionHandling;

public class Main {

    //declare exception
    static void divide(int a, int b) throws ArithmeticException{

        if(b==0){
            throw new ArithmeticException("Please don't divide by 0");
        }
    }
    public static void main(String[] args) {
        int a=5;
        int b=0;


        try
        {
           // divide(a,b);
//            int c=a/b;

            String name="SACHIN";

            if(name.equals("SACHIN")){
                throw new MyException("my name is this dash");
            }
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Normal Exception");
        }
        finally {
            System.out.println("This will always execute..");
        }






    }
}
