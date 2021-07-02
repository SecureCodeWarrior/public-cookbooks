public class DCL00J_IntraClass_Cycle_Bad {
    private final int balance;
    private static final DCL00J_IntraClass_Cycle_Bad c = new DCL00J_IntraClass_Cycle_Bad(); // Causes loop
    private static final int deposit = (int) (Math.random() * 100); // Random deposit

    public DCL00J_IntraClass_Cycle_Bad() {
        balance = deposit - 10; // Subtract processing fee
    }

    public static void main(String[] args) {
        System.out.println("The account balance is: " + c.balance);
    }
}