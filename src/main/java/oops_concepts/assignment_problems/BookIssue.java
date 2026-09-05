package oops_concepts.class_problems;

import java.util.Scanner;

public class BookIssue{
    String title;
    String borrowerName;
    int daysOverdue;

    public BookIssue(String title,String borrowerName,int daysOverdue){
        this.title=title;
        this.borrowerName=borrowerName;
        this.daysOverdue=daysOverdue;
    }

    public double fineAmount(){
        if(daysOverdue>0)
            return daysOverdue*5;
        return 0;
    }

    public boolean isSeverelyOverdue(){
        return daysOverdue>14;
    }

    // totalFineCollected is static because it calculates the total for all BookIssue objects, while fineAmount belongs to one book.
    public static double totalFineCollected(BookIssue[] issues){
        double total=0;
        for(BookIssue issue:issues)
            total+=issue.fineAmount();
        return total;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n=in.nextInt();
        in.nextLine();

        BookIssue[] issues=new BookIssue[n];

        for(int i=0;i<n;i++){
            System.out.print("Enter book title: ");
            String title=in.nextLine();

            System.out.print("Enter borrower name: ");
            String borrowerName=in.nextLine();

            System.out.print("Enter days overdue: ");
            int daysOverdue=in.nextInt();
            in.nextLine();

            issues[i]=new BookIssue(title,borrowerName,daysOverdue);
        }

        for(BookIssue issue:issues){
            if(issue.isSeverelyOverdue())
                System.out.println(issue.title+" - "+issue.daysOverdue+" days - Severely overdue");
            else
                System.out.println(issue.title+" - "+issue.daysOverdue+" days - OK");
        }

        System.out.println("Total fine collected: Rs "+BookIssue.totalFineCollected(issues));
    }
}