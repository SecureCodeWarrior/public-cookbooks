public class NUM13J_PrecisionToFloat {
    public static int subFloatFromIntBad(int op1, float op2) {
        return op1 - (int)op2;
    }

    public static int subFloatFromIntGood(int op1, float op2)
            throws ArithmeticException {

        // The significand can store at most 23 bits
        if ((op2 > 0x007fffff) || (op2 < -0x800000)) {
            throw new ArithmeticException("Insufficient precision");
        }

        return op1 - (int)op2;
    }

    public static int subDoubleFromIntGood(int op1, double op2) {
        return op1 - (int)op2;
    }

    public static void main(String[] args) {
        int result = subFloatFromIntBad(1234567890, 1234567890);
        // This prints -46, not 0, as may be expected
        System.out.println(result);

        result = subDoubleFromIntGood(1234567890, 1234567890);
        System.out.println(result);

        result = subFloatFromIntGood(1234567890, 1234567890);
        System.out.println(result);
    }

}
