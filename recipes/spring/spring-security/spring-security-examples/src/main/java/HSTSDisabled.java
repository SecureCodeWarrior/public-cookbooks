import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class HSTSDisabled extends WebSecurityConfigurerAdapter {
    /*Disabling HSTS creates vulnerabilities*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().httpStrictTransportSecurity().disable();
    }

    protected void configure1(HttpSecurity http) throws Exception {
        http
                .headers()
                .httpStrictTransportSecurity()
                .includeSubDomains(false);

    }
}
