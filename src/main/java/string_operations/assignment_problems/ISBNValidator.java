package string_operations.assignment_problems;
import java.util.Scanner;

class ISBNValidator{
    static String normalizeCode(String raw){
        raw=raw.trim();
        return raw.substring(0,3).toUpperCase()+raw.substring(3);
    }

    static String validateAndFormat(String code){
        if(code.length()!=13)
            return "Invalid: wrong length";

        for(int i=0;i<3;i++)
            if(!Character.isLetter(code.charAt(i)))
                return "Invalid: publisher code must be 3 letters";

        for(int i=3;i<13;i++)
            if(!Character.isDigit(code.charAt(i)))
                return "Invalid: body must contain digits";

        StringBuilder sb=new StringBuilder();
        sb.append("[");
        sb.append(code.substring(0,3));
        sb.append("] YEAR: ");
        sb.append(code.substring(3,7));
        sb.append(" | CATALOG: ");
        sb.append(code.substring(7));

        return sb.toString();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter ISBN code: ");
        String raw=in.nextLine();

        if(raw.trim().length()<3)
            System.out.println("Invalid: wrong length");
        else{
            String code=normalizeCode(raw);
            System.out.println(validateAndFormat(code));
        }
    }
}
