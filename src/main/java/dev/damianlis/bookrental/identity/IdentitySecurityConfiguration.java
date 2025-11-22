package dev.damianlis.bookrental.identity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class IdentitySecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1) uprawnienia
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/api/identities/**").permitAll()
                        .anyRequest().authenticated()
                )
                // 2) CSRF: wyłącz
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**", "/api/identities/**")
                )
                // 3) H2 używa ramek — zezwól z tej samej domeny
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                )
                // 4) jakaś forma logowania na resztę endpointów
                .httpBasic(Customizer.withDefaults()); // lub .formLogin()

        return http.build();
    }

}
