package string.class_problems;

import java.util.Scanner;

class PalindromeChecker{
    static boolean isPalindromeIterative(String text){
        for(int i=0,j=text.length()-1;i<j;i++,j--){
            if(text.charAt(i)!=text.charAt(j))
                return false;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text){
        if(text.length()<=1)
            return true;

        if(text.charAt(0)!=text.charAt(text.length()-1))
            return false;

        return isPalindromeRecursive(text.substring(1,text.length()-1));
    }

    static boolean isPalindromeArrayReversal(String text){
        char[] a=text.toCharArray();

        for(int i=0,j=a.length-1;i<j;i++,j--){
            char temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }

        return text.equals(new String(a));
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        System.out.print("Enter text: ");
        String text=in.nextLine();

        System.out.println("Iterative: "+(isPalindromeIterative(text)?"Palindrome":"Not Palindrome"));
        System.out.println("Recursive: "+(isPalindromeRecursive(text)?"Palindrome":"Not Palindrome"));
        System.out.println("Array Reversal: "+(isPalindromeArrayReversal(text)?"Palindrome":"Not Palindrome"));
    }
}