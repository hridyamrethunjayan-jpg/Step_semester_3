package oops_constructors.class_problems;
import java.util.Scanner;

public class FareSplitter{
    String tripId;
    double totalFare;
    int passengerCount;

    public FareSplitter(String tripId,double totalFare,int passengerCount){
        if(totalFare<0)
            throw new IllegalArgumentException("Fare cannot be negative");
        if(passengerCount<=0)
            throw new IllegalArgumentException("Passenger count must be positive");

        this.tripId=tripId;
        this.totalFare=totalFare;
        this.passengerCount=passengerCount;
    }

    public FareSplitter(String tripId,double totalFare){
        this(tripId,totalFare,2);
    }

    public FareSplitter(String tripId){
        this(tripId,0.0,2);
    }

    public double[] fareBreakdown(){
        double[] result=new double[passengerCount];
        long totalCents=Math.round(totalFare*100);
        long base=totalCents/passengerCount;
        long remainder=totalCents%passengerCount;

        for(int i=0;i<passengerCount-1;i++)
            result[i]=base/100.0;

        result[passengerCount-1]=(base+remainder)/100.0;

        return result;
    }

    public boolean isConfirmationOverdue(int confirmed,int expected){
        return confirmed<expected;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        FareSplitter f1=new FareSplitter("TRIP001",100000,3);
        System.out.println(java.util.Arrays.toString(f1.fareBreakdown()));

        FareSplitter f2=new FareSplitter("TRIP003");
        System.out.println(java.util.Arrays.toString(f2.fareBreakdown()));
    }
}