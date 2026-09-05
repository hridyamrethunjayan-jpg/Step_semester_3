package oops_constructors.assignment_problems;

class Canteen{
    String canteenCode;
    String canteenName;
    int trustScore;

    public Canteen(String canteenCode,String canteenName,int trustScore){
        this.canteenCode=canteenCode;
        this.canteenName=canteenName;
        this.trustScore=trustScore;
    }
    public Canteen(String canteenCode,String canteenName){
        this(canteenCode,canteenName,3);
    }
    int compareTo(Canteen other){
        if(this.trustScore>other.trustScore)
            return -1;
        if(this.trustScore<other.trustScore)
            return 1;

        int result=this.canteenCode.compareToIgnoreCase(other.canteenCode);

        if(result!=0)
            return result;

        return Integer.compare(this.canteenName.length(),other.canteenName.length());
    }
    static Canteen[] rankCanteens(Canteen[] canteens){
        Canteen[] result=canteens.clone();
        for(int i=0;i<result.length-1;i++){
            for(int j=0;j<result.length-1-i;j++){
                if(result[j].compareTo(result[j+1])>0){
                    Canteen temp=result[j];
                    result[j]=result[j+1];
                    result[j+1]=temp;
                }
            }
        }
        return result;
    }
}
public class CanteenTrustScore{
    public static void main(String[] args){
        Canteen[] canteens={
                new Canteen("HB3-C","Spice Junction",3),
                new Canteen("hb1-c","Grand Mess",5),
                new Canteen("HB2-C","Southern Treats")
        };

        Canteen[] ranked=Canteen.rankCanteens(canteens);

        System.out.print("[");
        for(int i=0;i<ranked.length;i++){
            System.out.print("\""+ranked[i].canteenCode+"\"");
            if(i<ranked.length-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}