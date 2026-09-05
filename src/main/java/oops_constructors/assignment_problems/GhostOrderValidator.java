package oops_constructors.assignment_problems;

class FoodOrder{
    private String studentName;
    private String dishName;
    private boolean delivered;

    public FoodOrder(String studentName,String dishName) {
        if (studentName == null || studentName.trim().isEmpty())
            throw new IllegalArgumentException();
        if (dishName == null || dishName.trim().isEmpty())
            throw new IllegalArgumentException();

        this.studentName = studentName;
        this.dishName = dishName;
    }
    public void markDelivered(){
        if(delivered)
            System.out.println("Order already delivered");
        else{
            delivered=true;
            System.out.println("Order delivered");
        }
    }
    static void processBatch(String[][] rawOrders){
        int valid=0;
        int rejected=0;

        for(String[] order:rawOrders){
            try{
                new FoodOrder(order[0],order[1]);
                valid++;
            }catch(Exception e){
                rejected++;
            }
        }
        System.out.println("Valid: "+valid+" | Rejected: "+rejected);
    }
}
public class GhostOrderValidator{
    public static void main(String[] args){
        String[][] rawOrders={
                {"Ravi","Paneer Butter Masala"},
                {"","Chole Bhature"},
                {"Meera"," "},
                {"Divya","Veg Biryani"}
        };
        FoodOrder.processBatch(rawOrders);
    }
}