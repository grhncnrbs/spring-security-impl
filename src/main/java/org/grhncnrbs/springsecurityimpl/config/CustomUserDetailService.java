package org.grhncnrbs.springsecurityimpl.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grhncnrbs.springsecurityimpl.model.entity.UserEntity;
import org.grhncnrbs.springsecurityimpl.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final static String ROLE_PREFIX = "ROLE_";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username {} ", username);
        Optional<UserEntity> user = this.userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        log.info("user {} ", user.get());
        String password = user.get().getPassword();
        log.info("password {} ", password);
        String role = user.get().getRole();
        log.info("before role {} ", role);
        role = ROLE_PREFIX + role;
        log.info("role with ROLE_PREFIX {} ", role);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role));
        log.info("roles {} ", roles);
        return new CustomUserDetails(username, password, roles);
    }
}
