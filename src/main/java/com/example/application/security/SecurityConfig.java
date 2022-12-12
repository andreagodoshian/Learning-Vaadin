package com.example.application.security;

import com.example.application.views.list.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration // "This is the configuration that we want to use"
public class SecurityConfig extends VaadinWebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http); // save the "super" for Vaadin
        setLoginView(http, LoginView.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**"); // hides images
        super.configure(web); // save the "super" for Vaadin
    }

    @Bean
    @Override // NOTE: THIS IS NOT RECOMMENDED FOR PRODUCTION (SADLY LOL)
    protected UserDetailsService userDetailsService() {
        // return super.userDetailsService();
        return new InMemoryUserDetailsManager(User.withUsername("user")
                .password("{noop}userpass").roles("USER").build());
    }
}
