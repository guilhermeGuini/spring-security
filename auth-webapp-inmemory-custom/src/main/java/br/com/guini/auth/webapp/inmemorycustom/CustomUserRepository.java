package br.com.guini.auth.webapp.inmemorycustom;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface CustomUserRepository {


    Optional<UserDetails> getByName(String username);
}
