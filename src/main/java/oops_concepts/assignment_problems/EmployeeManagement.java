package oops_concepts.assignment_problems;

import java.util.Scanner;

class Employee{
    private int empId;
    private String empName;
    private double salary;

    public Employee(int empId,String empName,double salary){
        this.empId=empId;
        this.empName=empName;
        this.salary=salary;
    }

    public double getSalary(){
        return salary;
    }
}

class ManagerEmployee extends Employee{
    private double teamBonus;

    public ManagerEmployee(int empId,String empName,double salary,double teamBonus){
        super(empId,empName,salary);
        this.teamBonus=teamBonus;
    }

    public double effectiveSalary(){
        return getSalary()+teamBonus;
    }
}

class InternEmployee extends Employee{
    private double stipendCap;

    public InternEmployee(int empId,String empName,double salary,double stipendCap){
        super(empId,empName,salary);
        this.stipendCap=stipendCap;
    }

    public double effectiveSalary(){
        return Math.min(getSalary(),stipendCap);
    }
}

public class EmployeeManagement{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id=in.nextInt();
        in.nextLine();

        System.out.print("Enter Employee Name: ");
        String name=in.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary=in.nextDouble();

        Employee employee=new Employee(id,name,salary);

        System.out.print("Enter Manager ID: ");
        int managerId=in.nextInt();
        in.nextLine();

        System.out.print("Enter Manager Name: ");
        String managerName=in.nextLine();

        System.out.print("Enter Manager Salary: ");
        double managerSalary=in.nextDouble();

        System.out.print("Enter Team Bonus: ");
        double bonus=in.nextDouble();

        ManagerEmployee manager=new ManagerEmployee(managerId,managerName,managerSalary,bonus);

        System.out.print("Enter Intern ID: ");
        int internId=in.nextInt();
        in.nextLine();

        System.out.print("Enter Intern Name: ");
        String internName=in.nextLine();

        System.out.print("Enter Intern Salary: ");
        double internSalary=in.nextDouble();

        System.out.print("Enter Stipend Cap: ");
        double cap=in.nextDouble();

        InternEmployee intern=new InternEmployee(internId,internName,internSalary,cap);

        System.out.println("\nEmployee Pay Details:");

        if(employee instanceof ManagerEmployee)
            System.out.println("Manager Pay: Rs "+((ManagerEmployee)employee).effectiveSalary());
        else if(employee instanceof InternEmployee)
            System.out.println("Intern Pay: Rs "+((InternEmployee)employee).effectiveSalary());
        else
            System.out.println("Employee Pay: Rs "+employee.getSalary());

        if(manager instanceof ManagerEmployee)
            System.out.println("Manager Pay: Rs "+manager.effectiveSalary());

        if(intern instanceof InternEmployee)
            System.out.println("Intern Pay: Rs "+intern.effectiveSalary());

        in.close();
    }
}