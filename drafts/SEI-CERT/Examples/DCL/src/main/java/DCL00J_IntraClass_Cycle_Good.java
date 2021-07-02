public class DCL00J_IntraClass_Cycle_Good {
    private final int balance;
    private static final int deposit = (int) (Math.random() * 100); // Random deposit
    private static final DCL00J_IntraClass_Cycle_Good c = new DCL00J_IntraClass_Cycle_Good();  // Inserted after initialization of required fields

    public DCL00J_IntraClass_Cycle_Good() {
        balance = deposit - 10; // Subtract processing fee
    }

    public static void main(String[] args) {
        System.out.println("The account balance is: " + c.balance);
    }
}