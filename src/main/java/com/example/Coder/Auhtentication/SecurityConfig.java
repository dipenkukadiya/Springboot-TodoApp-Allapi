package com.example.Coder.Auhtentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests().requestMatchers("/**").permitAll()
                // .antMatchers("/**").hasRole("OWNER")  // Full access for ROLE_OWNER
                // .antMatchers(HttpMethod.GET, "/api/v1/workspace/{workspaceId}").hasAnyRole("OWNER", "PROJECTMANAGER")  // Read access to workspace for ROLE_OWNER and ROLE_PROJECTMANAGER
                // .antMatchers("/api/v1/workspace/{workspaceId}/boards/**").hasAnyRole("OWNER", "PROJECTMANAGER")  // ROLE_OWNER and ROLE_PROJECTMANAGER access to boards
                // .antMatchers("/api/v1/workspace/{workspaceId}/boards/{boardId}/todolists/**").hasAnyRole("OWNER", "PROJECTMANAGER", "TEAMLEADER")  // ROLE_OWNER, ROLE_PROJECTMANAGER, and ROLE_TEAMLEADER access to todolists
                // .antMatchers("/api/v1/workspace/{workspaceId}/boards/{boardId}/todolists/{todoListId}/todos/**").hasAnyRole("OWNER", "PROJECTMANAGER", "TEAMLEADER", "DEVELOPER")  // All roles access to todos
                // .anyRequest().authenticated()
                .and().formLogin().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("hello");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(customUserDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

}
