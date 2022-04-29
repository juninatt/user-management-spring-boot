package iths.not3book.config;

import iths.not3book.sampledata.InMemoryDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

@Configuration
public class UserManagementConfig {


    @Bean
    public UserDetailsService userDetailsService() {
        String authority = "read";
        Collection<? extends GrantedAuthority> authorities = List.of(() -> authority);
        UserDetails u = new User("john", "12345", authorities);
        List<UserDetails> users = List.of(u);
        return new InMemoryDetailsService(users);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}