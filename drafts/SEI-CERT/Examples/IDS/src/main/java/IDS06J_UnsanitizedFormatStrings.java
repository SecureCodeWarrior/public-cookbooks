import java.util.Calendar;
import java.util.GregorianCalendar;

public class IDS06J_UnsanitizedFormatStrings
{
    static Calendar c = new GregorianCalendar(1995, GregorianCalendar.MAY, 23);
    public static void bad(String[] args) {
        // args[0] should contain the credit card expiration date
        // but might contain %1$tm, %1$te or %1$tY format specifiers
        System.out.format(
                args[0] + " did not match! HINT: It was issued on %1$terd of some month", c
        );
    }

    public static void good(String[] args) {
        // args[0] is the credit card expiration date
        // Perform comparison with c,
        // if it doesn't match, print the following line
        System.out.format(
                "%s did not match! HINT: It was issued on %terd of some month",
                args[0], c
        );
    }
}
