package string_operations.class_problems;
import java.util.Scanner;

class FileExtension{
    static String validateFileExtension(String filename){
        int i=filename.lastIndexOf('.');

        if(i==-1)
            return "Rejected — invalid file type";

        String ext=filename.substring(i+1);

        if(ext.equalsIgnoreCase("pdf")||
                ext.equalsIgnoreCase("docx")||
                ext.equalsIgnoreCase("zip"))
            return "Accepted";

        return "Rejected — invalid file type";
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter filename: ");
        String s=in.nextLine();
        System.out.println(validateFileExtension(s));
    }
}
