package oops_concepts.assignment_problems;

import java.util.Scanner;

class CompanyEmployeeRecord{
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;

    static int totalRecords=0;

    CompanyEmployeeRecord(String name,String empId,Employee employee,ParkingSlot slot){
        this.name=name;
        this.empId=empId;
        this.employee=employee;
        this.slot=slot;
        totalRecords++;
    }

    String fullProfile(){
        double pay;

        if(employee instanceof ManagerEmployee)
            pay=((ManagerEmployee)employee).effectiveSalary();
        else if(employee instanceof InternEmployee)
            pay=((InternEmployee)employee).effectiveSalary();
        else
            pay=employee.getSalary();

        if(slot!=null)
            return name+" | Pay: Rs "+pay+" | Slot: "+slot.slotNo;
        else
            return name+" | Pay: Rs "+pay+" | Slot: no parking assigned";
    }
}
class HRParkingMiniSystem{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n=in.nextInt();
        in.nextLine();

        CompanyEmployeeRecord[] records=new CompanyEmployeeRecord[n];

        for(int i=0;i<n;i++){
            System.out.println("\nEmployee "+(i+1));

            System.out.print("Enter name: ");
            String name=in.nextLine();

            System.out.print("Enter employee ID: ");
            String empId=in.nextLine();

            System.out.print("Enter employee type (1-Employee, 2-Manager, 3-Intern): ");
            int type=in.nextInt();

            System.out.print("Enter salary: ");
            double salary=in.nextDouble();

            Employee employee;

            if(type==2){
                System.out.print("Enter team bonus: ");
                double bonus=in.nextDouble();
                employee=new ManagerEmployee(Integer.parseInt(empId),name,salary,bonus);
            }else if(type==3){
                System.out.print("Enter stipend cap: ");
                double cap=in.nextDouble();
                employee=new InternEmployee(Integer.parseInt(empId),name,salary,cap);
            }else{
                employee=new Employee(Integer.parseInt(empId),name,salary);
            }

            in.nextLine();

            System.out.print("Enter parking slot number (or none): ");
            String slotNo=in.nextLine();

            ParkingSlot slot=null;

            if(!slotNo.equalsIgnoreCase("none")){
                System.out.print("Enter slot capacity: ");
                int capacity=in.nextInt();

                System.out.print("Enter occupied count: ");
                int occupied=in.nextInt();
                in.nextLine();

                slot=new ParkingSlot(slotNo,capacity,occupied);
            }

            records[i]=new CompanyEmployeeRecord(name,empId,employee,slot);
        }

        System.out.println("\nEmployee Parking Slots:");

        for(CompanyEmployeeRecord record:records)
            System.out.println(record.fullProfile());

        System.out.println("Total records: "+CompanyEmployeeRecord.totalRecords);
    }
}