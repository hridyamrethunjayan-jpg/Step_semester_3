package string_operations.class_problems;

import java.util.Scanner;

class StudentRecord{
    static void parseStudentRecord(String csvLine){
        String[] a=csvLine.split(",");

        if(a.length!=3)
            System.out.println("Invalid Record");
        else
            System.out.println("Name: "+a[0]+" | Roll No: "+a[1]+" | Dept: "+a[2]);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter student record: ");
        String s=in.nextLine();
        parseStudentRecord(s);
    }
}
