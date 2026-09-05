package oops_concepts.assignment_problems;

class BrokenLibraryMember{
    static String name;
    static String memberId;
    static int booksIssued;

    BrokenLibraryMember(String name,String memberId,int booksIssued){
        BrokenLibraryMember.name=name;
        BrokenLibraryMember.memberId=memberId;
        BrokenLibraryMember.booksIssued=booksIssued;
    }

    // name, memberId and booksIssued should not be static because each member has separate data
}

class LibraryMember{
    String name;
    String memberId;
    int booksIssued;

    static String libraryName="Central Library";
    static int memberCount=0;

    LibraryMember(String name,int booksIssued){
        this.name=name;
        this.booksIssued=booksIssued;
        memberCount++;
        this.memberId="LM-"+(1000+memberCount);
    }

    void printMemberCard(){
        System.out.println(name+" | "+memberId);
    }

    static void printTotalMembers(){
        System.out.println("Total members: "+memberCount);
    }
}

public class LibraryMembershipSystem{
    public static void main(String[] args){

        System.out.println("Broken version:");

        BrokenLibraryMember m1=new BrokenLibraryMember("Aditi","LM-1001",2);
        BrokenLibraryMember m2=new BrokenLibraryMember("Rohan","LM-1002",3);

        System.out.println(m1.name);
        System.out.println(m2.name);

        System.out.println();

        System.out.println("Fixed version:");

        LibraryMember a=new LibraryMember("Aditi",2);
        LibraryMember r=new LibraryMember("Rohan",3);

        a.printMemberCard();
        r.printMemberCard();

        LibraryMember.printTotalMembers();
    }
}