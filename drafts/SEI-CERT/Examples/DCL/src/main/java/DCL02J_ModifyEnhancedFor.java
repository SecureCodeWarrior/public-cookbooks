import java.util.Arrays;
import java.util.List;

public class DCL02J_ModifyEnhancedFor {
    public void bad() {
        List<Integer> list = Arrays.asList(13, 14, 15);
        boolean first = true;

        System.out.println("Processing list...");
        for (Integer i: list) {
            if (first) {
                first = false;
                i = 99;
            }
            System.out.println(" New item: " + i);
            // Process i
        }

        System.out.println("Modified list?");
        for (Integer i: list) {
            System.out.println("List item: " + i);
        }
    }

    public void good() {
        List<Integer> list = Arrays.asList(13, 14, 15);
        boolean first = true;

        System.out.println("Processing list...");
        for (final Integer i: list) {
            Integer item = i;
            if (first) {
                first = false;
                item = 99;
            }
            System.out.println(" New item: " + item);
            // Process item
        }

        System.out.println("Modified list?");
        for (Integer i: list) {
            System.out.println("List item: " + i);
        }
    }

}
