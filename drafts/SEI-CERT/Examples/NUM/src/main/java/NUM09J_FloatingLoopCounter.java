public class NUM09J_FloatingLoopCounter {
    public static void bad(String[] args) {
        for (float x = 0.1f; x <= 1.0f; x += 0.1f) {
            System.out.println(x);
        }

        for (float x = 100000001.0f; x <= 100000010.0f; x += 1.0f) {
            /* ... */
        }
    }

    public static void good(String[] args) {
        for (int count = 1; count <= 10; count += 1) {
            float x = count/10.0f;
            System.out.println(x);
        }

        for (int count = 1; count <= 10; count += 1) {
            double x = 100000000.0 + count;
            /* ... */
        }
    }
}
