package iths.not3book.config;

 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserManagementConfig {


    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        String usersByUsernameQuery =
                "SELECT user_name, password, enabled FROM author WHERE user_name = ?";
        String authsByUserQuery = "SELECT user_name, authority FROM authorities WHERE user_name = ?";

        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
        
        userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        
        userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
        
        return userDetailsManager;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}