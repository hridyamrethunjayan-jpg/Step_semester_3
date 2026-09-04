package string_operations.class_problems;
import java.util.Scanner;

class MaskPhoneNumber{
    static String maskPhoneNumber(String phone){
        if(phone.length()!=10)
            return "Invalid phone number";

        for(int i=0;i<phone.length();i++)
            if(!Character.isDigit(phone.charAt(i)))
                return "Invalid phone number";

        StringBuilder sb=new StringBuilder("XXXXXX");
        sb.insert(6,"-"+phone.substring(6));

        return sb.toString();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter phone number: ");
        String phone=in.nextLine();

        System.out.println(maskPhoneNumber(phone));
    }
}