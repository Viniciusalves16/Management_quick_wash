package com.example.management.entities.login;

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
public class RoleModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(nullable = false, unique = true)
    private String name;


    public enum Values {
        BASIC(2),
        ADMIN(1);

        long roleId;

        Values(long roleId) {
            this.roleId = roleId;
        }
    }
}
