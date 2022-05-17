package iths.not3book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuration class that handles authorization logic.
 * @see WebSecurityConfigurerAdapter
 */
@Configuration
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {

    /**
     * Method that decides which requests should be authorized and what the response should be.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .anyRequest().authenticated();
    }
}