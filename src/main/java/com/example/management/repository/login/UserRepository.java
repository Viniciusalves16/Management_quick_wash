package com.example.management.repository.login;

import com.example.management.entities.login.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

  UserDetails findByLogin(String login);
}
