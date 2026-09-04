package string_operations.assignment_problems;
import java.util.Scanner;

class ATMPinLength{
    static void checkPinLength(String pin){
        if(pin.length()!=4)
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        else
            System.out.println("PIN length OK.");
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter PIN: ");
        String pin=in.nextLine();
        checkPinLength(pin);
    }
}