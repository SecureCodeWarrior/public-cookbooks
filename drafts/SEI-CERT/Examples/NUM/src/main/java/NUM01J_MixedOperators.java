public class NUM01J_MixedOperators {
    public static void bad(String[] args) {
        int x = 50;
        x += (x << 2) + 1;

        x = 50;
        int y = x << 2;
        x += y + 1;

        x = -50;
        x >>>= 2;

        x = -50;
        x >>= 2;

        // b[] is a byte array, initialized to 0xff
        byte[] b = new byte[] {-1, -1, -1, -1};
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = ((result << 8) + b[i]);
        }

        for (int i = 0; i < 4; i++) {
            result = ((result << 8) + (b[i] & 0xff));
        }
    }

    public static void good(String[] args) {
        int x = 50;
        x = 5 * x + 1;

        x = -50;
        x /= 4;

        byte[] b = new byte[] {-1, -1, -1, -1};
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = ((result << 8) | (b[i] & 0xff));
        }
    }

}
