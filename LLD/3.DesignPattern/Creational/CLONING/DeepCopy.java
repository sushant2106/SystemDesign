class Address implements  Cloneable{

  String city;

    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}

class Person implements Cloneable {

    String name;
    Address address;

    @Override
    public Person clone() throws CloneNotSupportedException {

        Person cloned = (Person) super.clone();

        cloned.address = address.clone();

        return cloned;
    }
}

public class DeepCopy {

    public static void main(String[] args) {
        
    
    }
    
}
