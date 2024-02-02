package com.example.Coder.Auhtentication;

import java.util.Set;
import java.util.Optional;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Coder.Entity.User;
import com.example.Coder.Repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserRepo userRepo; 
    @Transactional
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user details from the database
        Optional<User> optionalUser = Optional.ofNullable(userRepo.findByUsername(username));

        // Use orElseThrow with a lambda expression or a proper exception message
        User user = optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Convert roles to authorities
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toSet());

        return new CustomUserDetails(user.getUsername(), user.getPassword(), authorities);
    }
}