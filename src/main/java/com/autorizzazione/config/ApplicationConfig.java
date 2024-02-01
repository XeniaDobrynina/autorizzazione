package com.autorizzazione.config;

import com.autorizzazione.repo.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private static final String USER_NOT_FOUND_MESSAGE = "Utente con username %s non trovato";
    private final UserJpaRepository repository;

    @Bean
    public UserDetailsService userDetailService(){
        return username -> repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE)));
    }
}
