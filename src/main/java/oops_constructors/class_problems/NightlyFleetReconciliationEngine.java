package oops_constructors.class_problems;

class BusTicketAccount{
    String bookingId;
    double ticketFare;
    static int accountCount;
    static{
        accountCount=0;
    }
    public BusTicketAccount(String bookingId,double ticketFare){
        this.bookingId=bookingId;
        this.ticketFare=ticketFare;
        accountCount++;
    }

    public BusTicketAccount(String bookingId){
        this(bookingId,0);
    }

    public final double calculatePenalty(int minutesLate){
        if(ticketFare<0||minutesLate<0)
            throw new IllegalArgumentException("Invalid input");
        if(minutesLate==0)
            return 0.0;

        double penalty=0.0;
        int first=Math.min(minutesLate,5);
        penalty+=ticketFare*0.005*first;

        if(minutesLate>5){
            int second=Math.min(minutesLate,15)-5;
            penalty+=ticketFare*0.01*second;
        }
        if(minutesLate>15){
            int third=minutesLate-15;
            penalty+=ticketFare*0.02*third;
        }
        return penalty;
    }
}

class Sleeper extends BusTicketAccount{
    public Sleeper(String bookingId,double ticketFare){
        super(bookingId,ticketFare);
    }
}

public class NightlyFleetReconciliationEngine{
    static void processAccount(BusTicketAccount account,double amount,int minutesLate){
        if(account==null)
            return;

        account.ticketFare=amount;
        account.calculatePenalty(minutesLate);
    }

    static void processBatch(BusTicketAccount[] accounts,double[] amounts,int[] minutesLateArray){
        int processed=0;
        int nullSkipped=0;
        int sleeper=0;
        int regular=0;
        double grandTotal=0;
        int length=Math.min(accounts.length,Math.min(amounts.length,minutesLateArray.length));

        for(int i=0;i<length;i++){
            if(accounts[i]==null){
                nullSkipped++;
                continue;
            }
            accounts[i].ticketFare=amounts[i];
            grandTotal+=accounts[i].calculatePenalty(minutesLateArray[i]);
            processed++;
            if(accounts[i] instanceof Sleeper)
                sleeper++;
            else
                regular++;
        }
        System.out.println(processed+" processed | "+nullSkipped+" null skipped | "+sleeper+" sleeper | "+regular+" regular | grand total penalties = "+grandTotal);
    }
    public static void main(String[] args){
        BusTicketAccount[] accounts={
                new Sleeper("BK001",2000),
                null,
                new BusTicketAccount("BK002",1200)
        };

        double[] amounts={1200,900,700};
        int[] minutesLateArray={10,5,0};
        processBatch(accounts,amounts,minutesLateArray);
    }
}