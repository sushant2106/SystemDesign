package com.sushant.access;

public class ObjectDemo  {

    int num;
    public ObjectDemo(int num) {
        super();

        this.num=num;
    }

    @Override
    public int hashCode() {

        //unique representation of object via hashcode
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {

        ObjectDemo obj=new ObjectDemo(34);

        System.out.println(obj.hashCode());

        System.out.println(obj instanceof  Object);

        System.out.println(obj.getClass());
        //data about the classes
        System.out.println(obj.getClass().arrayType());

    }
}
