package com.zup.gerenciarImpostos.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalculoImpostoRequest {
    private Long tipoImpostoId;
    private Double ValorBase;

}