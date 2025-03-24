package com.zup.gerenciarImpostos.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "impostos")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImpostoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double aliquota;
}