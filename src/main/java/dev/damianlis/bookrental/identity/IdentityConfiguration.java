package dev.damianlis.bookrental.identity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class IdentityConfiguration {

    @Bean
    IdentityFacade identityFacade(
            IdentityRepository identityRepository,
            PasswordEncoder passwordEncoder
    ) {
        IdentityService identityService = new IdentityService(identityRepository, passwordEncoder);
        return new IdentityFacade(identityService);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
