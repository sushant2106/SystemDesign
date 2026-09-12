package com.sushant.genrics;

import java.util.Arrays;
import java.util.List;

//here T should be either Number of Its SubClass

public class WildCardExample<T extends  Number> {

    private  Object[] data;
    private static  int DEFAULT_SIZE=10;
    private int size=0; //also working as index value


    public WildCardExample(){

        this.data=new Object[DEFAULT_SIZE];
    }
   //List<? extends Number> list
//    public void getList(List<Number> list){
//        //do something
//
//        //here you can only pass the Number type
//    }





    public void add(T num){
        if(this.isFull()){
            resize();
        }
        data[size++]= num;
    }

    public  void resize(){

        Object[] temp= new Object[data.length*2];

        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }

        data=temp; //data is pointing to temp

    }

    private boolean isFull(){
        return size == data.length;
    }

    public T remove(){
        T removed=(T)(data[--size]);
        return removed;
    }

    public  T get(int index){
        return  (T)data[index];
    }

    public  int size(){
        return size;
    }

    public  void set(int index,T value){
        data[index]=value;

    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {


        WildCardExample<Integer> list = new WildCardExample<>();

        list.add(3);
        list.add(4);

        System.out.println(list);

    }
}
