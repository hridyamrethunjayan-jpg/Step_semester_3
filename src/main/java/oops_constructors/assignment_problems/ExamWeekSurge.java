package oops_constructors.assignment_problems;

public final class ExamWeekSurge{
    private final double minimumSurgePercent;
    public ExamWeekSurge(double minimumSurgePercent){
        this.minimumSurgePercent=minimumSurgePercent;
    }
    public final double calculateSurgeFee(double orderValue,int delayMinutes){
        if(orderValue<0||delayMinutes<0)
            throw new IllegalArgumentException();
        if(delayMinutes==0)
            return 0.0;

        double fee=0.0;
        int first=Math.min(delayMinutes,5);
        fee+=orderValue*0.005*first;

        if(delayMinutes>5){
            int second=Math.min(delayMinutes,15)-5;
            fee+=orderValue*0.01*second;
        }
        if(delayMinutes>15){
            int third=delayMinutes-15;
            fee+=orderValue*0.02*third;
        }
        double minimumFee=orderValue*minimumSurgePercent/100;
        return Math.max(fee,minimumFee);
    }
    public static void main(String[] args){
        ExamWeekSurge feeCalculator=new ExamWeekSurge(1);

        System.out.println("Rs "+feeCalculator.calculateSurgeFee(500,0));
        System.out.println("Rs "+feeCalculator.calculateSurgeFee(500,1));
        System.out.println("Rs "+feeCalculator.calculateSurgeFee(500,16));
    }
}