package com.techfeel.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService customUserDetailsService;
    
    /**
     * allow /login,/oauth/authorize path without http secutiry
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.requestMatchers()
                .antMatchers("/login", "/oauth/authorize")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll();
    }

    /**
     * configure inMemory or external database authentication here
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*auth.parentAuthenticationManager(authenticationManager)
                .inMemoryAuthentication()
                .withUser("Twinkle")
                .password("Twinkle")
                .roles("USER");*/
    	 auth.parentAuthenticationManager(authenticationManager)
         .userDetailsService(customUserDetailsService);
    }
}

