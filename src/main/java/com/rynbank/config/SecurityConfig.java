package com.rynbank.config;

import com.rynbank.filter.CSRFCookieFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http
                // Set to not generate JSESSIONID
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // Set to configure CORS
                .and()
                .cors().configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(List.of("Authorization"));
                    config.setMaxAge(3600L);
                    return config;
                })
                // Set URLs where CSRF is not going to be applicable
                .and().csrf((csrf) ->
                        csrf
                                .csrfTokenRequestHandler(requestHandler)
                                .ignoringRequestMatchers("/contact", "/register")
                                // Set to create CSRF cookie and let the Angular application read that cookie value
                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                // Set filters
                .addFilterAfter(new CSRFCookieFilter(), BasicAuthenticationFilter.class)
                // Set which requests the configuration will be applied to
                .authorizeHttpRequests()
                .requestMatchers("/myAccount").hasRole("USER")
                .requestMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/myLoans").authenticated()
                .requestMatchers("/myCards").hasRole("USER")
                .requestMatchers("/user").authenticated()
                .requestMatchers("/notices", "/contact", "/register").permitAll()
                .and().oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
        return http.build();
    }

}
