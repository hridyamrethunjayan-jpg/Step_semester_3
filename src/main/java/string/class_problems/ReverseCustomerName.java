package string.class_problems;

import java.util.Scanner;

class ReverseCustomerName{
    static String reverseCustomerName(String customerName){
        char[] a=customerName.toCharArray();

        for(int i=0,j=a.length-1;i<j;i++,j--){
            char temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }

        return new String(a);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName=in.nextLine();

        System.out.println("Original Name: "+customerName);
        System.out.println("Reversed Name: "+reverseCustomerName(customerName));
    }
}