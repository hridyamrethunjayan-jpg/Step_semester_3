package string.assignment_problems;

class SeatChecker{
    static void checkDuplicateSeats(int[] seatNumbers){
        boolean found=false;
        for(int i=0;i<seatNumbers.length;i++){
            for(int j=i+1;j<seatNumbers.length;j++){
                if(seatNumbers[i]==seatNumbers[j]){
                    System.out.println("Duplicate seat number found: "+seatNumbers[i]);
                    found=true;
                }
            }
        }
        if(found==false){
            System.out.println("No duplicate seats found");
        }
    }
    public static void main(String args[]){
        int[] seats={101,102,103,104,102};
        checkDuplicateSeats(seats);
    }
}