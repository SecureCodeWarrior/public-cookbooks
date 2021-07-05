public class NUM12J_NarrowConversionLoss {
    public static void bad(String[] args) {
        int num = 128;
        workWithBad(num);

        float i = Float.MIN_VALUE;
        float j = Float.MAX_VALUE;
        short b = (short) i;
        short c = (short) j;

        double i2 = Double.MIN_VALUE;
        double j2 = Double.MAX_VALUE;
        float b2 = (float) i2;
        float c2 = (float) j2;
    }

    public static void workWithBad(int i) {
        byte b = (byte) i;  // b has value -128
        // Work with b
    }

    public static void good(String[] args) {
        int num = 128;
        workWithGood(num);

        float i = Float.MIN_VALUE;
        float j = Float.MAX_VALUE;
        if ((i < Short.MIN_VALUE) || (i > Short.MAX_VALUE) ||
                (j < Short.MIN_VALUE) || (j > Short.MAX_VALUE)) {
            throw new ArithmeticException ("Value is out of range");
        }

        short b = (short) i;
        short c = (short) j;

        double i2 = Double.MIN_VALUE;
        double j2 = Double.MAX_VALUE;
        if ((i2 < Float.MIN_VALUE) || (i2 > Float.MAX_VALUE) ||
                (j2 < Float.MIN_VALUE) || (j2 > Float.MAX_VALUE)) {
            throw new ArithmeticException ("Value is out of range");
        }

        float b2 = (float) i2;
        float c2 = (float) j2;
    }

    public static void workWithGood(int i) {
        // Check whether i is within byte range
        if ((i < Byte.MIN_VALUE) || (i > Byte.MAX_VALUE)) {
            throw new ArithmeticException("Value is out of range");
        }

        byte b = (byte) i;
        // Work with b
    }

    public static void workWithGoodModulo(int i) {
        byte b = (byte)(i % 0x100); // 2^8;
        // Work with b
    }



}
