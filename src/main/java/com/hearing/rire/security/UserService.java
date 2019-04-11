package com.hearing.rire.security;

import com.hearing.rire.bean.User;
import com.hearing.rire.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Create by hearing on 19-4-10
 */
public class UserService implements UserDetailsService {

    @Autowired
    private UserServices userServices;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userServices.getUserByName(s);
        if (user == null) {
            return null;
        } else {
            return new User(s, new BCryptPasswordEncoder().encode(user.getPassword()));
        }
    }
}
