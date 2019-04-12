package com.hearing.rire.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Create by hearing on 19-4-10
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()    // 禁用 Spring Security 自带的跨域处理,不然loginProcessingUrl配置失效
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/loginConfirm")
                .usernameParameter("name").passwordParameter("password")
                .defaultSuccessUrl("/index")
                .permitAll()
                .and()
                .logout().clearAuthentication(true).invalidateHttpSession(true).logoutUrl("/logout").logoutSuccessUrl("/index")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
