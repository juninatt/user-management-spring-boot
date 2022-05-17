package iths.not3book.config;

import iths.not3book.authorities.Authority;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/**
 * Configuration class that handles user management for security purposes.
 */
@Configuration
public class UserManagementConfig {

    /**
     * Bean annotated method that connects to the data source specified in the application.properties file.
     * It then fetches all enabled authors{@link iths.not3book.author.Author}, recognizes them as users in the spring security context
     * and gives them the authorities{@link Authority} associated with the user.
     * @see UserDetailsService
     * @see JdbcUserDetailsManager
     */
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        String usersByUsernameQuery = "SELECT user_name, password, enabled FROM author WHERE user_name = ?";
        String authorityByUserQuery = "SELECT user_name, authority FROM authority WHERE user_name = ?";

        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
        
        userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        
        userDetailsManager.setAuthoritiesByUsernameQuery(authorityByUserQuery);
        
        return userDetailsManager;
    }

    /**
     * Bean annotated method return the password encoder.
     * Currently, using NoOpPasswordEncoder for testing purposes.
     * @see PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}