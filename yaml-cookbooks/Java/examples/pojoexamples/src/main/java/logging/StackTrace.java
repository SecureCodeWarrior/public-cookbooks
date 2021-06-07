package logging;

import java.io.PrintStream;
import java.io.PrintWriter;

public class StackTrace {

    public void testLoggingRecipe() {
        try {
            // Do anything that can trigger an exception
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace(new PrintStream(System.err));
            e.printStackTrace(new PrintWriter(System.err));
        }
    }

}
