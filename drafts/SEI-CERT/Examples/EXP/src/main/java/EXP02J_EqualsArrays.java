import java.util.Arrays;

public class EXP02J_EqualsArrays {
    public void bad() {
        int[] arr1 = new int[20]; // Initialized to 0
        int[] arr2 = new int[20]; // Initialized to 0
        System.out.println(arr1.equals(arr2)); // Prints false
    }

    public void good() {
        int[] arr1 = new int[20]; // Initialized to 0
        int[] arr2 = new int[20]; // Initialized to 0
        System.out.println(Arrays.equals(arr1, arr2)); // Prints true
    }

    public void goodDoubleEquals() {
        int[] arr1 = new int[20]; // Initialized to 0
        int[] arr2 = new int[20]; // Initialized to 0
        System.out.println(arr1 == arr2); // Prints false
    }
}
