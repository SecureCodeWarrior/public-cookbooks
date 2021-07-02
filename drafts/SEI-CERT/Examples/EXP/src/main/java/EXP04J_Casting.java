import java.util.HashSet;

public class EXP04J_Casting {
    public static void bad(String[] args) {
        HashSet<Short> s = new HashSet<Short>();
        for (int i = 0; i < 10; i++) {
            s.add((short)i); // Cast required so that the code compiles
            s.remove(i); // Tries to remove an Integer
        }
        System.out.println(s.size());
    }

    public static void good(String[] args) {
        HashSet<Short> s = new HashSet<Short>();
        for (int i = 0; i < 10; i++) {
            s.add((short)i);
            // Remove a Short
            if (s.remove((short)i) == false) {
                System.err.println("Error removing " + i);
            }
        }
        System.out.println(s.size());
    }
}
