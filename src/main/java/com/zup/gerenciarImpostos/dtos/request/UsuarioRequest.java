package com.zup.gerenciarImpostos.dtos.request;

import com.zup.gerenciarImpostos.dtos.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    private String username;
    private String password;
    private RoleEnum role;
}