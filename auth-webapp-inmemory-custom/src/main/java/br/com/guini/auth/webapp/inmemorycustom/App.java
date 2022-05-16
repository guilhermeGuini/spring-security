package br.com.guini.auth.webapp.inmemorycustom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;

import java.util.Map;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    public CustomUserRepository customUserRepository() {
        var users = Map.of(
                "guini", User.builder()
                        .username("guini")
                        .password("{bcrypt}$2a$10$1MdD/uxBoABE8zprfLiKg.Mp1gsRInfvD6B2Tbdravtza.erlWDby")
                        .roles("USER")
                        .build(),
                "admin", User.builder()
                        .username("admin")
                        .password("{bcrypt}$2a$10$1MdD/uxBoABE8zprfLiKg.Mp1gsRInfvD6B2Tbdravtza.erlWDby")
                        .roles("ADMIN")
                        .build());
        return new CustomUserRepositoryImpl(users);
    }
}
