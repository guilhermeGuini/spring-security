package br.com.guini.auth.webapp.inmemorydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Autowired
    public void authManager(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser(User.builder()
                        .username("guini")
                        .password("{bcrypt}$2a$10$1MdD/uxBoABE8zprfLiKg.Mp1gsRInfvD6B2Tbdravtza.erlWDby")
                        .roles("USER"))
                .withUser(User.builder()
                        .username("teste")
                        .password("{bcrypt}$2a$10$1MdD/uxBoABE8zprfLiKg.Mp1gsRInfvD6B2Tbdravtza.erlWDby")
                        .roles("NO_PERMISSION"))
                .withUser(User.builder()
                        .username("admin")
                        .password("{bcrypt}$2a$10$1MdD/uxBoABE8zprfLiKg.Mp1gsRInfvD6B2Tbdravtza.erlWDby")
                        .roles("ADMIN"));
    }

    @Configuration
    public static class ApiSecurityAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                .authorizeHttpRequests()
                    .antMatchers("/unsecure/**")
                    .permitAll()
                .anyRequest()
                    .authenticated()
                .and()
                    .formLogin();
        }
    }

}
