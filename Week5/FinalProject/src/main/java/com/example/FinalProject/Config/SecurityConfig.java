package com.example.FinalProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user1 = User.builder()
                .username("admin")
                .password("{noop}test123")
                .roles("ADMIN", "USER")
                .build();
        UserDetails user2 = User.builder()
                .username("user")
                .password("{noop}test1234")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.POST, "/tkd/importStudents").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/tkd/students").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "tkd/student/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "tkd/students/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "tkd/student").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "tkd/student").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "tkd/student/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "tkd/allStudents").hasRole("ADMIN")

        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
