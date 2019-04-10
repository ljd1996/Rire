package com.hearing.rire.security;

import com.hearing.rire.bean.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Create by hearing on 19-4-10
 */
public class UserService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return new User(s, new BCryptPasswordEncoder().encode("123456"));
    }
}
