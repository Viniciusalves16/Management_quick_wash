package com.example.management.service;

import com.example.management.repository.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//Toda vez que a app receber um requisiçao, essa classe realiza a busca na base de dados
@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //verificaçao e tratamento de exceçao
        try {
            UserDetails userDetails = userRepository.findByLogin(username);
            if (userDetails == null) {
                throw new UsernameNotFoundException("User Not Found " + username);
            }
            return userDetails;
        } catch (Exception ex) {
            throw new UsernameNotFoundException("Error Search User !!");
        }


    }
}
