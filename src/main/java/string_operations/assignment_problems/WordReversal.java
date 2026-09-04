package string_operations.assignment_problems;

import java.util.Scanner;

class WordReversal{
    static String reverseEachWord(String sentence){
        String[] words=sentence.split(" ");
        StringBuilder result=new StringBuilder();

        for(String word:words){
            StringBuilder sb=new StringBuilder(word);
            result.append(sb.reverse()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String s=in.nextLine();

        System.out.println(reverseEachWord(s));
    }
}