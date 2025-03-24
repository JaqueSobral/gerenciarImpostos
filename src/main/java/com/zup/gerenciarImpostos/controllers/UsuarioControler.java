package com.zup.gerenciarImpostos.controllers;

import com.zup.gerenciarImpostos.dtos.UsuarioResponse;
import com.zup.gerenciarImpostos.dtos.request.LoginRequest;
import com.zup.gerenciarImpostos.dtos.request.UsuarioRequest;
import com.zup.gerenciarImpostos.dtos.response.AuthResponse;
import com.zup.gerenciarImpostos.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsuarioControler {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioControler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<UsuarioResponse> criarUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest){
    UsuarioResponse usuarioResponse = usuarioService.criarUsuario(usuarioRequest);
    return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
    }

    @PostMapping("/user/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = usuarioService.login(loginRequest);
        AuthResponse authResponse = AuthResponse.builder()
                .accessToken(token)
                .build();
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }
}