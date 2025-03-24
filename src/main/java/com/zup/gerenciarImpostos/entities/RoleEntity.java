package com.zup.gerenciarImpostos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public RoleEntity(String name) {
        this.name = name;
    }

    public RoleEntity(){
    }

    public String name() {
        return name;
    }
}