package staticinjection;

import com.google.inject.AbstractModule;

import reporters.ILineReporter;
import reporters.SystemOutReporter;

public class SystemOutModule extends AbstractModule {

    @Override
    protected void configure() {
        binder().bind(ILineReporter.class).to(SystemOutReporter.class);
        //binder().requestStaticInjection(CountReporter.class);
    }
}
