package org.pgm.shopserver.security;

import lombok.RequiredArgsConstructor;
import org.pgm.shopserver.model.Role;
import org.pgm.shopserver.security.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configurable
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) //restAPI 사용할 때는 무조건 disable 사용해야 함
                .cors(httpSecurityCorsConfigurer -> corsConfigurationSource())
                .sessionManagement((sessiion) ->sessiion.
                        sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((authz) ->authz
                        .requestMatchers("/api/authentication/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/product/**").permitAll()
                        .requestMatchers("/api/product/**").hasRole(Role.ADMIN.name())
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAurhorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    private JwtAuthorizationFilter jwtAurhorizationFilter() {
        return new JwtAuthorizationFilter();
    }

    @Bean  //로그인 처리하는 빈 AuthenticationManager를 통해서 로그인 처리가 됨
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
    throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
