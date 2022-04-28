package iths.not3book.sampledata;

import iths.not3book.exception.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryDetailsService implements UserDetailsService {

    private final List<UserDetails> users;

    public InMemoryDetailsService(List<UserDetails> users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return users.stream()
                .filter(
                        user -> user.getUsername().equals(userName)
                )
                .findFirst()
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "username", userName)
                );
    }
}
