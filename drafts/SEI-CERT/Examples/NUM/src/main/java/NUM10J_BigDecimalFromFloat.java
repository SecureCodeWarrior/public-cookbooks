import java.math.BigDecimal;

public class NUM10J_BigDecimalFromFloat {
    public static void bad(String[] args) {
        // Prints 0.1000000000000000055511151231257827021181583404541015625
        // when run in FP-strict mode
        System.out.println(new BigDecimal(0.1));
    }

    public static void good(String[] args) {
        // Prints 0.1
        // when run in FP-strict mode
        System.out.println(new BigDecimal("0.1"));
    }
}
