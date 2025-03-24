package com.zup.gerenciarImpostos.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoImpostoRequest {
    private String name;
    private String descricao;
    private Double aliquota;
}