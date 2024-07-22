import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    Employee(String name,int id){
        this.name = name;
        this.id = id;
    }

    public String getname(){
        return name;
    }

    public int getId(){
        return id;
    }


    public abstract double calculateSalary();

    @Override
    public java.lang.String toString() {
        return "Employee [name = "+name+" ,id = "+id+" ,salary = "+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    int monthlySalary;

    FullTimeEmployee(String name, int id , int monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    int hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String name, int id , int hoursWorked , double hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate*hoursWorked;
    }
}

class PayRollSystem {
    private ArrayList<Employee> employee;
    PayRollSystem(){
        employee =  new ArrayList<>();
    }

    public void addEmp(Employee emp1){
        employee.add(emp1);
    }
    public void removeEmp(int id){
        Employee emp2Remove = null;
        for(Employee emp : employee){
            if(emp.getId()==id){
                emp2Remove = emp;
                break;
            }
        }
        if(emp2Remove!=null){
            employee.remove(emp2Remove);
        }
    }

    public void printEmp() {
        String header = String.format("| %-20s | %-10s | %-15s |", "Name", "ID", "Salary");
        String line = new String(new char[header.length()]).replace("\0", "-");

        System.out.println(line);
        System.out.println(header);
        System.out.println(line);

        for (Employee emp : employee) {
            String empDetails = String.format("| %-20s | %-10d | %-15.2f |", emp.getname(), emp.getId(), emp.calculateSalary());
            System.out.println(empDetails);
        }

        System.out.println(line);
    }
}


public class Main {
    public static void main(String[] args) {
        PayRollSystem prs = new PayRollSystem();
        FullTimeEmployee femp1 = new FullTimeEmployee("Shyam",1,10000);
        FullTimeEmployee femp2 = new FullTimeEmployee("Chandru",2,7500);
        FullTimeEmployee femp3 = new FullTimeEmployee("Murali",3,12500);
        PartTimeEmployee fpte1 = new PartTimeEmployee("chan",2,50,100);

        prs.addEmp(femp1);
        prs.addEmp(fpte1);
        prs.addEmp(femp2);
        prs.addEmp(femp3);
        prs.printEmp();
        prs.removeEmp(2);
        prs.printEmp();


    }
}