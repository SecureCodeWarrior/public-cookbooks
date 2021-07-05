public class NUM07J_NaNCompare {
    public static void bad(String[] args) {
        double x = 0.0;
        double result = Math.cos(1/x); // Returns NaN if input is infinity
        if (result == Double.NaN) { // Comparison is always false!
            System.out.println("result is NaN");
        }
    }

    public static void good(String[] args) {
        double x = 0.0;
        double result = Math.cos(1/x); // Returns NaN when input is infinity
        if (Double.isNaN(result)) {
            System.out.println("result is NaN");
        }
    }
}
