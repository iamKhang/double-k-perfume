package org.lehoangkhang.doublekperfume;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    @SuppressWarnings("deprecation")
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeRequests(auth ->
                        auth
                                .requestMatchers("/admin").hasAuthority("ADMIN")
                                .requestMatchers("/**").permitAll()
                                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated())
                .formLogin(login -> login.loginPage("/login").loginProcessingUrl("/login").usernameParameter("username")
                        .passwordParameter("password").defaultSuccessUrl("/admin", true))
                .logout(logout -> logout.logoutUrl("/admin-logout").logoutSuccessUrl("/login") );
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
                "/assets/**", "/assetsUser/**", "uploads/**", "/assetsAdmin/**"
        );
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}