package com.example.management.repository.login;

import com.example.management.entities.login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // metodo que realiza a consulta do usuário do banco de dados
    UserDetails findByLogin(String username);
}
