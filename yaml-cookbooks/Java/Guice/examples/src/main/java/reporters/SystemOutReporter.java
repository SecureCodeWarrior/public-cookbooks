package reporters;

public class SystemOutReporter implements ILineReporter {

    public void report(String reportLine){
        System.out.println(
            String.format(
                "%s%n",
                reportLine)
        );
    }
}
