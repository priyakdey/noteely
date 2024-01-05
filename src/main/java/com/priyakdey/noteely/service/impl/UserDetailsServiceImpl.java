package com.priyakdey.noteely.service.impl;

import com.priyakdey.noteely.model.User;
import com.priyakdey.noteely.repository.UserRepository;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Concrete implementation of {@link UserDetailsService} interface. This has one method
 * called loadUserByUsername which helps fetch credentials for the given username.
 *
 * @author Priyak Dey
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.map(this::mapToUserDetails)
            .orElseThrow(() -> new UsernameNotFoundException(username + " is not found"));
    }

    /**
     * Helper method to map application domain {@link User} object to spring security
     * specific {@link org.springframework.security.core.userdetails.User} object.
     *
     * @param user {@link User}
     * @return user credentials in shape of UserDetails.
     */
    private org.springframework.security.core.userdetails.User mapToUserDetails(User user) {
        Set<SimpleGrantedAuthority> grantedAuthorities =
            user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            user.isEnabled(),
            user.isAccountNonExpired(),
            user.isCredentialsNonExpired(),
            user.isAccountNonLocked(),
            grantedAuthorities
        );
    }
}
