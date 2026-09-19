class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Student implements Cloneable {
    String name;
    Address address;

    Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}



public class Shallow {

    public static void main(String[] args)  throws Exception{

        Address address=new  Address("Delhi");

        Student s1=new Student("Rahul", address);

        Student s2=s1.clone();

        s2.name="Sachin";
        s2.address.city="Patna";

        System.out.println(s1.name);
        System.out.println(s1.address.city);

        
    }
    
}
