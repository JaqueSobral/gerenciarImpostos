package com.zup.gerenciarImpostos.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "roles")
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nome;
    public Roles(String nome) {
        this.nome = nome;
    }
    public String nome() {
        return nome;
    }
}
