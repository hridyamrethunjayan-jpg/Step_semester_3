package string.class_problems;
import java.util.*;

class RockPaperScissors{
    static String playRound(String p,String c){
        if(p.equals(c))return "Draw";
        if((p.equals("Rock")&&c.equals("Scissors"))||(p.equals("Paper")&&c.equals("Rock"))||(p.equals("Scissors")&&c.equals("Paper")))return "Player Wins";
        return "Computer Wins";
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] moves={"Rock","Paper","Scissors"};
        int w=0,l=0,d=0;
        for(int i=1;i<=5;i++){
            System.out.print("Enter Rock, Paper or Scissors: ");
            String p=sc.next();
            String c=moves[new Random().nextInt(3)];
            String r=playRound(p,c);
            if(r.equals("Player Wins"))w++;
            else if(r.equals("Computer Wins"))l++;
            else d++;
            System.out.println("Round "+i+" | Player: "+p+" | Computer: "+c+" | Result: "+r);
        }
        System.out.println("Wins: "+w+" | Losses: "+l+" | Draws: "+d+" | Win % = "+(w*100.0/5)+"%");
    }
}