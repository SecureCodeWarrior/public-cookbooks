import java.util.ArrayList;

public class EXP06J_AssertionsSideEffects {
    private ArrayList<String> names;

    void processBad(int index) {
        assert names.remove(null); // Side effect
        // ...
    }

    void processGood(int index) {
        boolean nullsRemoved = names.remove(null);
        assert nullsRemoved; // No side effect
        // ...
    }
}
