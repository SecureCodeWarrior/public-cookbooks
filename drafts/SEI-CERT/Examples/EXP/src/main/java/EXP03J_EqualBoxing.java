import java.util.ArrayList;

public class EXP03J_EqualBoxing {
    public int compareBad(Integer i, Integer j) {
        return i < j ? -1 : (i == j ? 0 : 1);
    }

    public int compareGood(Integer i, Integer j) {
        return i < j ? -1 : (i > j ? 1 : 0) ;
    }

    public static void bad(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 1000;
        Integer i4 = 1000;
        System.out.println(i1 == i2);
        System.out.println(i1 != i2);
        System.out.println(i3 == i4);
        System.out.println(i3 != i4);
    }

    public static void good(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 1000;
        Integer i4 = 1000;
        System.out.println(i1.equals(i2));
        System.out.println(!i1.equals(i2));
        System.out.println(i3.equals(i4));
        System.out.println(!i3.equals(i4));
    }

    public static void bad2(String[] args) {
        // Create an array list of integers, where each element
        // is greater than 127
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list1.add(i + 1000);
        }

        // Create another array list of integers, where each element
        // has the same value as the first list
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list2.add(i + 1000);
        }

        // Count matching values
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            if (list1.get(i) == list2.get(i)) {  // Uses '=='
                counter++;
            }
        }

        // Print the counter: 0 in this example
        System.out.println(counter);
    }

    public static void good2(String[] args) {
        // Create an array list of integers
        ArrayList<Integer> list1 = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            list1.add(i + 1000);
        }

        // Create another array list of integers, where each element
        // has the same value as the first one
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list2.add(i + 1000);
        }

        // Count matching values
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            if (list1.get(i).equals(list2.get(i))) {  // Uses 'equals()'
                counter++;
            }
        }

        // Print the counter: 10 in this example
        System.out.println(counter);
    }

    public void exampleEqualOperatorBad(){
        Boolean b1 = new Boolean("true");
        Boolean b2 = new Boolean("true");

        if (b1 == b2) {    // Never equal
            System.out.println("Never printed");
        }
    }

    public void exampleEqualOperatorGood(){
        Boolean b1 = true;
        Boolean b2 = true;

        if (b1 == b2) {   // Always equal
            System.out.println("Always printed");
        }

        b1 = Boolean.TRUE;
        if (b1 == b2) {   // Always equal
            System.out.println("Always printed");
        }
    }
}
