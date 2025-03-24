package com.zup.gerenciarImpostos.dtos.response;

import com.zup.gerenciarImpostos.dtos.RoleEnum;
import lombok.Data;

@Data
public class LoginResponse {
    private String username;
    private String password;
    private RoleEnum role;
}
