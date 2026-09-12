import java.util.ArrayList;
import java.util.List;

class Department {

    private String departmentName;
    private List<Employee> employees = new ArrayList<>();

    Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void assignEmployee(Employee newEmployee) {

        if (!employees.contains(newEmployee)) {
            employees.add(newEmployee);
            newEmployee.assignDepartment(this);
        }
    }

    public String showDepartment(){
        return  this.departmentName;
    }

    
}

class Employee {

    private String name;
    private Department department;

    Employee(String name) {
        this.name = name;
    }

    public void assignDepartment(Department newDepartment) {

        if (this.department == null) {
            this.department = newDepartment;
            newDepartment.assignEmployee(this);
        }
    }

    public String voidNameofEMpl(){
        return this.name;
    }
}

public class Man2One {
    public static void main(String[] args) {

        Department engineering = new Department("Engineering");

    //    Employee sachin = new Employee("Sachin");
    //    Employee rahul = new Employee("Rahul");
       Employee priya = new Employee("Priya");

       priya.assignDepartment(engineering
       );
       

    //    engineering.assignEmployee(priya);

       
    }
}
