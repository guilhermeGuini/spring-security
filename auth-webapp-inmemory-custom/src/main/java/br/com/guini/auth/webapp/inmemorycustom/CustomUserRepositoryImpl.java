package br.com.guini.auth.webapp.inmemorycustom;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.Optional;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final Map<String, UserDetails> users;

    public CustomUserRepositoryImpl(Map<String, UserDetails> users) {
        this.users = users;
    }

    @Override
    public Optional<UserDetails> getByName(String username) {
        if (!users.containsKey(username)) {
            return Optional.empty();
        }

        return Optional.of(users.get(username));
    }
}
