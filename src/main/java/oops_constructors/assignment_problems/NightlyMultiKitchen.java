package oops_constructors.assignment_problems;

class DeliveryAccount{
    String studentId;
    double orderValue;
    static int accountCount;
    static{
        accountCount=0;
    }
    public DeliveryAccount(String studentId,double orderValue){
        this.studentId=studentId;
        this.orderValue=orderValue;
        accountCount++;
    }
    public DeliveryAccount(String studentId){
        this(studentId,0);
    }

    public final double calculateSurgeFee(int delayMinutes){
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
        return fee;
    }
}
class Premium extends DeliveryAccount{
    public Premium(String studentId,double orderValue){
        super(studentId,orderValue);
    }
}
class NightlyMultiKitchenReconciliationEngine{
    void processAccount(DeliveryAccount account,double amount,int delayMinutes){
        if(account==null)
            return;
        account.orderValue=amount;

        if(account instanceof Premium)
            account.calculateSurgeFee(delayMinutes);
        else
            account.calculateSurgeFee(delayMinutes);
    }
    static void processBatch(DeliveryAccount[] accounts,double[] amounts,int[] delayMinutesArray){
        int processed=0;
        int nullSkipped=0;
        int premium=0;
        int regular=0;
        double grandTotal=0;

        int length=Math.min(accounts.length,
                Math.min(amounts.length,delayMinutesArray.length));
        NightlyMultiKitchenReconciliationEngine processor=
                new NightlyMultiKitchenReconciliationEngine();

        for(int i=0;i<length;i++){
            if(accounts[i]==null){
                nullSkipped++;
                continue;
            }

            processor.processAccount(accounts[i],amounts[i],delayMinutesArray[i]);
            grandTotal+=accounts[i].calculateSurgeFee(delayMinutesArray[i]);
            processed++;

            if(accounts[i] instanceof Premium)
                premium++;
            else
                regular++;
        }
        System.out.println(processed+" processed | "+nullSkipped+
                " null skipped | "+premium+" premium | "+regular+
                " regular | grand total surge fees = "+grandTotal);
    }
    public static void main(String[] args){
        DeliveryAccount[] accounts={
                new Premium("STU001",500),
                null,
                new DeliveryAccount("STU002",300)
        };

        double[] amounts={500,400,300};
        int[] delayMinutesArray={10,5,0};
        processBatch(accounts,amounts,delayMinutesArray);
    }
}