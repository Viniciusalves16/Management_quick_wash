package com.example.management.repository;

import com.example.management.models.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterModel, UUID> {



}
