package com.zup.gerenciarImpostos.services;

import com.zup.gerenciarImpostos.dtos.UsuarioResponse;
import com.zup.gerenciarImpostos.dtos.request.LoginRequest;
import com.zup.gerenciarImpostos.dtos.request.UsuarioRequest;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    String login(LoginRequest loginRequest);
    UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest);
}