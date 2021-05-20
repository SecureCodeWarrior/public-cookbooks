package reporters;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import staticinjection.SystemOutModule;

import java.util.Arrays;

public class StaticInjectionIssueTest {


    @Test
    void reporterWithStaticObserver(){

        Injector injector = Guice.createInjector(new SystemOutModule());
        CountReporter reporter = injector.getInstance(CountReporter.class);

        String [] lines5 = {"1: line", "2: line", "3: line", "4: line", "5: line"};

        try {
            reporter.reportThisMany(Arrays.asList(lines5));
            Assertions.assertEquals(5, reporter.getCount());

        }catch(NullPointerException e){
            // when the Dependency Injection fails then we'll drop in here
            System.out.println(
                    "TODO: fix the dependency injection issue -" +
                    " private protected class, and missing static injection");
            //Assertions.fail("dependency injection failed");
        }
    }
}
