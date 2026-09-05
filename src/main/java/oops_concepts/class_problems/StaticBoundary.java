package oops_concepts.class_problems;
import java.util.Scanner;

class BrokenStudent{
    //name,regNo and attendance as static is wrong because each student will have different data
    static String name;
    static String regNo;
    static int attendance;

    BrokenStudent(String name,String regNo,int attendance){
        BrokenStudent.name=name;
        BrokenStudent.regNo=regNo;
        BrokenStudent.attendance=attendance;
    }
}

class SrmStudentFixed{
    String name;
    String regNo;
    int attendance;

    static String university="SRM";
    static int admissionCount=0;

    SrmStudentFixed(String name,int attendance){
        this.name=name;
        this.attendance=attendance;
        admissionCount++;
        regNo="RA2311003010"+(10+admissionCount);
    }

    void printIdCard(){
        System.out.println(name+" | "+regNo);
    }

    static void printTotalAdmissions(){
        System.out.println("Students admitted so far: "+admissionCount);
    }
}

class StaticBoundary{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        System.out.println("Broken version:");

        BrokenStudent s1=new BrokenStudent("Ravi","RA101",80);
        BrokenStudent s2=new BrokenStudent("Meera","RA102",90);

        System.out.println(s1.name);
        System.out.println(s2.name);

        System.out.println();

        System.out.println("Fixed version:");

        SrmStudentFixed s3=new SrmStudentFixed("Ravi",80);
        SrmStudentFixed s4=new SrmStudentFixed("Meera",90);

        s3.printIdCard();
        s4.printIdCard();

        SrmStudentFixed.printTotalAdmissions();
    }
}
