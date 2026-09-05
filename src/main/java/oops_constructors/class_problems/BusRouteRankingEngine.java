package oops_constructors.class_problems;

class BusRoute{
    String routeCode;
    String routeName;
    int priority;

    public BusRoute(String routeCode,String routeName,int priority){
        this.routeCode=routeCode;
        this.routeName=routeName;
        this.priority=priority;
    }

    public BusRoute(String routeCode,String routeName){
        this(routeCode,routeName,0);
    }

    public int compareTo(BusRoute other){
        if(this.priority>other.priority)
            return -1;
        if(this.priority<other.priority)
            return 1;
        return 0;
    }

    public static BusRoute[] rankRoutes(BusRoute[] routes){
        BusRoute[] result=routes.clone();

        for(int i=0;i<result.length-1;i++){
            for(int j=0;j<result.length-1-i;j++){
                if(result[j].compareTo(result[j+1])>0){
                    BusRoute temp=result[j];
                    result[j]=result[j+1];
                    result[j+1]=temp;
                }
            }
        }
        return result;
    }
}

public class BusRouteRankingEngine{
    public static void main(String[] args){
        BusRoute[] routes={
                new BusRoute("RT205L","Chennai-Pondicherry",3),
                new BusRoute("rt201j","Chennai-Bangalore",4),
                new BusRoute("RT299T","Chennai-Madurai")
        };

        BusRoute[] ranked=BusRoute.rankRoutes(routes);

        System.out.print("[");
        for(int i=0;i<ranked.length;i++){
            System.out.print("\""+ranked[i].routeCode+"\"");
            if(i<ranked.length-1)
                System.out.print(",");
        }
        System.out.println("]");
    }
}