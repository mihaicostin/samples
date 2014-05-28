package com.mc.spring.sample.web.services.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {

        //TODO: The custom user lookup (e.g. in a database)
        //for now dummy user - (admin, pass)

        return new SpecificUserDetails("admin", "pass", true);
    }

    public static class SpecificUserDetails implements UserDetails {

        public static final String SCOPE_READ = "read";
        public static final String SCOPE_WRITE = "write";
        public static final String ROLE_USER = "ROLE_USER";
        private final String username;
        private final String password;
        private final boolean enabled;

        private Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        public SpecificUserDetails(String username, String pass, boolean enabled) {
            this.username = username;
            this.password = pass;
            this.enabled = enabled;
            for (String ga : Arrays.asList(ROLE_USER, SCOPE_READ, SCOPE_WRITE)) {
                this.grantedAuthorities.add(new SimpleGrantedAuthority(ga));
            }

        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.grantedAuthorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return isEnabled();
        }

        @Override
        public boolean isAccountNonLocked() {
            return isEnabled();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return isEnabled();
        }

        @Override
        public boolean isEnabled() {
            return enabled;
        }

    }
}