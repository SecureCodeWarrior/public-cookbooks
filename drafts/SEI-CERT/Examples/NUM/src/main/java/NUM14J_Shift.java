public class NUM14J_Shift {
    static int countOneBitsBad(long value) {
        int bits = 0;
        while (value != 0) { // Infinite loop as sign bit is not cleared
            bits += value & 1L;
            value >>= 1; // Signed right shift, by one
        }
        return bits;
    }

    static int countOneBitsGood( long value ) {
        int bits = 0;
        while (value != 0) {
            bits += value & 1L;
            value >>>= 1;
        }
        return bits;
    }

    public static void bad(String[] args) {
        byte b = 'a';
        int result = b >>> 2;

        int i = 0;
        while ((-1 << i) != 0) {
            i++;
        }
    }

    public static void good(String[] args) {
        byte b = 'a';
        int result = ((int) b & 0xFF) >>> 2;

        for (int val = -1; val != 0; val <<= 1) { /* ... */ }
    }

    public int doOperationBad(int exp) {
        // Compute 2^exp
        int temp = 1 << exp;
        // Do other processing
        return temp;
    }

    public int doOperationGood(int exp) throws ArithmeticException {
        if ((exp < 0) || (exp >= 32)) {
            throw new ArithmeticException("Exponent out of range");
        }
        // Safely compute 2^exp
        int temp = 1 << exp;
        // Do other processing
        return temp;
    }


}
