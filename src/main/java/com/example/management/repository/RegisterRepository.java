package com.example.management.repository;

import com.example.management.entities.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegisterRepository extends JpaRepository<Register, UUID> {



}
