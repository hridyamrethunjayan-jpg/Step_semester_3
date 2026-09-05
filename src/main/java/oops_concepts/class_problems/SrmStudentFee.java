package oops_concepts.class_problems;

public class SrmStudentFee {
    String name;
    String regNo;
    HostelFeeAccount feeAccount;
    HostelRoom room;

    static int totalStudents = 0;

    SrmStudentFee(String name, String regNo, HostelFeeAccount feeAccount, HostelRoom room) {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        this.room = room;
        totalStudents++;
    }

    String fullStatus() {
        String roomNumber;

        if (room == null)
            roomNumber = "unallotted";
        else
            roomNumber = room.roomNo;

        return name + " | Due: Rs " + feeAccount.getDue()
                + " | Room: " + roomNumber;
    }

    public static void main(String[] args) {

        HostelFeeAccount raviFee =
                new HostelFeeAccount("RA101", 200000, 60000);

        HostelFeeAccount anithaFee =
                new HostelFeeAccount("RA102", 200000, 20000);

        HostelFeeAccount karthikFee =
                new HostelFeeAccount("RA103", 200000, 0);

        HostelRoom room1 =
                new HostelRoom("C-214", 3, 2);

        HostelRoom room2 =
                new HostelRoom("C-507", 2, 2);

        // Valid and rejected payments
        raviFee.pay(0);
        raviFee.pay(-5000);

        anithaFee.pay(0);

        karthikFee.pay(0);

        SrmStudentFee ravi =
                new SrmStudentFee("Ravi", "RA101", raviFee, room1);

        SrmStudentFee anitha =
                new SrmStudentFee("Anitha", "RA102", anithaFee, room2);

        SrmStudentFee karthik =
                new SrmStudentFee("Karthik", "RA103", karthikFee, null);

        System.out.println(ravi.fullStatus());
        System.out.println(anitha.fullStatus());
        System.out.println(karthik.fullStatus());

        System.out.println("Total students: " + totalStudents);
    }
}