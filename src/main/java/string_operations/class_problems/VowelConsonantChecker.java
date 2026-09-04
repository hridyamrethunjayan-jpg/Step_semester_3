package string_operations.class_problems;
import java.util.Scanner;

class VowelConsonantChecker{
    static void countVowelsAndConsonants(String text){
        int v=0,c=0;

        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);

            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
                    ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
                v++;
            else if(ch!=' ')
                c++;
        }

        System.out.println("Vowels: "+v+" | Consonants: "+c);
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter text: ");
        String text=in.nextLine();
        countVowelsAndConsonants(text);
    }
}
