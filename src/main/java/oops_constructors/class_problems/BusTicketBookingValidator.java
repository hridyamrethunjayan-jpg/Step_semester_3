package oops_constructors.class_problems;

class BusTicket{
    private String passengerName;
    private String destination;
    private boolean checkedIn;

    public BusTicket(String passengerName,String destination){
        if(passengerName==null||passengerName.trim().isEmpty())
            throw new IllegalArgumentException("Invalid passenger name");

        if(!passengerName.matches("[a-zA-Z ]+"))
            throw new IllegalArgumentException("Invalid passenger name");

        if(destination==null||destination.trim().isEmpty())
            throw new IllegalArgumentException("Invalid destination");

        this.passengerName=passengerName.trim();
        this.destination=destination.trim();
    }

    public void markCheckedIn(){
        if(checkedIn)
            throw new IllegalStateException("Already checked in");

        checkedIn=true;
    }

    public static void processBatch(String[][] rawBookings){
        int valid=0;
        int rejected=0;
        int duplicates=0;

        String[][] accepted=new String[rawBookings.length][2];

        for(String[] booking:rawBookings){
            try{
                BusTicket ticket=new BusTicket(booking[0],booking[1]);

                boolean duplicate=false;

                for(int i=0;i<valid;i++){
                    if(accepted[i][0].equalsIgnoreCase(ticket.passengerName)&&
                            accepted[i][1].equalsIgnoreCase(ticket.destination)){
                        duplicate=true;
                        break;
                    }
                }

                if(duplicate){
                    duplicates++;
                }else{
                    accepted[valid][0]=ticket.passengerName;
                    accepted[valid][1]=ticket.destination;
                    valid++;
                }

            }catch(Exception e){
                rejected++;
            }
        }

        System.out.println("Valid: "+valid);
        System.out.println("Rejected: "+rejected);
        System.out.println("Duplicates skipped: "+duplicates);
    }
}

public class BusTicketBookingValidator{
    public static void main(String[] args){

        String[][] rawBookings={
                {"Divya","Chennai"},
                {"","Bangalore"},
                {"Ravi123","Pune"},
                {"Divya","Chennai"},
                {" "," "}
        };

        BusTicket.processBatch(rawBookings);
    }
}