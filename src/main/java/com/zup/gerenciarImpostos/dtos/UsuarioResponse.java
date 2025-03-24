package com.zup.gerenciarImpostos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponse {
    private Long id;
    private String username;
    private RoleEnum role;

    public UsuarioResponse() {
    }
}