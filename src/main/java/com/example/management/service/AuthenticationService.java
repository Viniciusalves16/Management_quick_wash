package com.example.management.service;

import com.example.management.repository.login.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//classe inicializada de forma automatica pelo spring,
// implementando o método que realiza a consulta do usuário no banco de dados através da interface

@Service
public class AuthenticationService implements UserDetailsService {

    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        return userRepository.findByLogin(username);
    }
}
