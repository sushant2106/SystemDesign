class Employee{
   
    String employeName;
    private Laptop laptop;
   


    Employee(String employeName){
        this.employeName=employeName;
    }

    public void assignLaptop(Laptop companyLaptop){

        if(this.laptop ==null){
            this.laptop=companyLaptop;
            companyLaptop.assignUser(this);
        }   

    }


}

class Laptop{

    String laptopname;
    private Employee employee;

    Laptop(String laptopname){
        this.laptopname=laptopname;
    }

    public void assignUser(Employee newEmployee){
        if(this.employee ==null){
            this.employee=newEmployee;
            newEmployee.assignLaptop(this);
        }

        
    }

}

public class One2One {



     public static void main(String[] args) {

        Employee sachin=new Employee("Sachin");

        Laptop dell=new Laptop("Dell");

        sachin.assignLaptop(dell);
        
     }
}
