package com.zup.gerenciarImpostos.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalculoImpostoResponse {
    private String tipoImposto;
    private double valorBase;
    private double aliquota;
    private double valorImposto;
}