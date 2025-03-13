package com.zup.gerenciarImpostos.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImpostoDto {
        private Long id;
        private String nome;
        private String descricao;
        private Double aliquota;
}