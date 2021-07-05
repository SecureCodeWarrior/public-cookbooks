import java.math.BigDecimal;

public class NUM11J_FloatStringCompare {
    public static void bad(String[] args) {
        int i = 1;
        String s = Double.valueOf(i / 1000.0).toString();
        if (s.equals("0.001")) {
            // ...
        }

        i = 1;
        s = Double.valueOf(i / 1000.0).toString();
        s = s.replaceFirst("[.0]*$", "");
        if (s.equals("0.001")) {
            // ...
        }

        i = 1;
        s = Double.valueOf(i / 10000.0).toString();
        s = s.replaceFirst("[.0]*$", "");
        if (s.equals("0.0001")) {
            // ...
        }
    }

    public static void good(String[] args) {
        int i = 1;
        BigDecimal d = new BigDecimal(Double.valueOf(i / 1000.0).toString());
        if (d.compareTo(new BigDecimal("0.001")) == 0) {
            // ...
        }
    }
}
