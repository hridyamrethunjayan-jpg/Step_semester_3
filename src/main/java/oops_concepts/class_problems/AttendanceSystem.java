package oops_concepts.class_problems;
import java.util.Scanner;

class SrmStudent{
    String name;
    String regNo;
    int attendance;

    SrmStudent(String name,String regNo,int attendance){
        this.name=name;
        this.regNo=regNo;
        this.attendance=attendance;
    }

    void addAttendanceUpdate(int newAttendance){
        attendance=newAttendance;
    }

    boolean isEligible(){
        return attendance>=75;
    }
    //classAverage is static because it works on the entire array whereas isEligible is not static as it belongs to only one object.
    static double classAverage(SrmStudent[] students){
        int total=0;
        for(SrmStudent s:students)
            total+=s.attendance;
        return (double)total/students.length;
    }
}

public class AttendanceSystem{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n=in.nextInt();
        in.nextLine();

        SrmStudent[] students=new SrmStudent[n];

        for(int i=0;i<n;i++){
            System.out.println("\nStudent "+(i+1));

            System.out.print("Enter name: ");
            String name=in.nextLine();

            System.out.print("Enter register number: ");
            String regNo=in.nextLine();

            System.out.print("Enter attendance: ");
            int attendance=in.nextInt();
            in.nextLine();

            students[i]=new SrmStudent(name,regNo,attendance);
        }

        System.out.println("\nAttendance Report");

        for(SrmStudent s:students){
            System.out.println(s.name+" - "+(s.isEligible()?"Eligible":"Detained"));
        }

        System.out.println("Class Average: "+SrmStudent.classAverage(students)+"%");
    }
}