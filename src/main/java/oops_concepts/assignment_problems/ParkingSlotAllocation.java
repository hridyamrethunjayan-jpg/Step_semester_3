package oops_concepts.assignment_problems;

class ParkingSlot{
    String slotNo;
    int capacity;
    int occupiedCount;

    public ParkingSlot(String slotNo,int capacity,int occupiedCount){
        this.slotNo=slotNo;
        this.capacity=capacity;
        this.occupiedCount=occupiedCount;
    }

    public void allot(String vehicleNo){
        if(occupiedCount<capacity){
            occupiedCount++;
            System.out.println(vehicleNo+" allotted to slot "+slotNo);
        }
    }

    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots){
        for(ParkingSlot slot:slots){
            if(slot.occupiedCount<slot.capacity)
                return slot;
        }
        return null;
    }

    public static void safeAllot(ParkingSlot[] slots,String vehicleNo){
        ParkingSlot slot=findAvailableSlot(slots);

        if(slot!=null)
            slot.allot(vehicleNo);
        else
            System.out.println("No slots available for "+vehicleNo);
    }
}

public class ParkingSlotAllocation{
    public static void main(String[] args){
        ParkingSlot[] slots={
                new ParkingSlot("A1",4,3),
                new ParkingSlot("A2",5,5)
        };

        System.out.println("Slots: A1 ("+slots[0].occupiedCount+"/"+slots[0].capacity+"), A2 ("+slots[1].occupiedCount+"/"+slots[1].capacity+")");
        //The array contains references to ParkingSlot objects, not copies of the objects, changes made in array affect original objects
        ParkingSlot.safeAllot(slots,"TN09AB1234");

        System.out.println("Slots: A1 ("+slots[0].occupiedCount+"/"+slots[0].capacity+"), A2 ("+slots[1].occupiedCount+"/"+slots[1].capacity+")");
        ParkingSlot.safeAllot(slots,"TN09AB1234");
    }
}