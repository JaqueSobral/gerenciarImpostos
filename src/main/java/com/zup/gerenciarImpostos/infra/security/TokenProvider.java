package com.zup.gerenciarImpostos.infra.security;

import com.zup.gerenciarImpostos.entities.Usuario;

public interface TokenProvider {
    String generateToken(Usuario usuario);
    boolean validateRefreshToken(String refreshToken);
    String refreshAccessToken(String refreshToken);
}
