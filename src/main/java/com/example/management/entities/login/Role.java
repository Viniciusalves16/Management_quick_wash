package com.example.management.entities.login;

import com.example.management.enumeration.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_ROLE")
public class Role implements GrantedAuthority, Serializable {
    private static final long serialVersuionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private UUID roleId;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleType name;


    @Override
    public String getAuthority() {
        return this.name.toString();
    }
}
