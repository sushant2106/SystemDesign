
class Person implements Cloneable{

    String name;
    int age;

    // Person(String name,int age){
        // this.name=name;
        // this.age=age;
    //}
    
    void get() {
        System.out.println("Getting data from Parent");
    }

    @Override 
    public  Person clone() throws CloneNotSupportedException{
        return (Person) super.clone();
    }
 
}

// class Man extends Person{
    // String house;
// 
    // public Man(String name,int age,String house){
        // 
        // super(name,age);
        // this.house=house;
        // super.get();
    // }
// 
// 
    // void get() {
        // System.out.println("Getting data Child");
    // }
// 
// }


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
      
        // Person p1=new Person();

        // p1.name="Jhon";
        // p1.age=23;

       // Man obj=new Man("KarlMarx",80,"Germany");

        //System.out.println(obj.name);

        //obj.get();

        Person p1=new Person();

        p1.name="Karl Marx";
        p1.age=80;

       Person p2=p1.clone();

        System.out.println(p1.name);
        System.out.println(p2.name);

        System.out.println(p1 == p2);






    }
}