package com.zup.gerenciarImpostos.services;

import com.zup.gerenciarImpostos.dtos.UsuarioResponse;
import com.zup.gerenciarImpostos.dtos.RoleEnum;
import com.zup.gerenciarImpostos.dtos.request.LoginRequest;
import com.zup.gerenciarImpostos.dtos.request.UsuarioRequest;
import com.zup.gerenciarImpostos.entities.RoleEntity;
import com.zup.gerenciarImpostos.entities.UsuarioEntity;
import com.zup.gerenciarImpostos.infra.security.JwtTokenProvider;
import com.zup.gerenciarImpostos.repositories.RoleRepository;
import com.zup.gerenciarImpostos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

    public UsuarioServiceImpl(AuthenticationManager authenticationManager) {
    }

    @Override
    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest) {

        if (usuarioRequest.getUsername() == null || usuarioRequest.getUsername().isEmpty()) {
            throw new IllegalArgumentException("O campo username não pode ser nulo ou vazio.");
        }
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setUsername(usuarioRequest.getUsername());
        usuarioEntity.setPassword(bCryptPasswordEncoder.encode(usuarioRequest.getPassword()));

        UsuarioEntity user = new UsuarioEntity();
        user.setUsername(usuarioRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(usuarioRequest.getPassword()));

        RoleEnum roleType = usuarioRequest.getRole();
        RoleEntity role = new RoleEntity();
        role.setName(roleType.name());
        roleRepository.save(role);

        user.setRole(role);
        usuarioRepository.save(user);

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(user.getId());
        usuarioResponse.setUsername(user.getUsername());
        usuarioResponse.setRole(roleType);
        return usuarioResponse;
    }


    @Override
    public String login(LoginRequest loginRequest) {
        if (loginRequest == null) {
            throw new IllegalArgumentException("Erro ao realizar login: LoginRequest inválido.");
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
             )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }

    private String authenticateUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return jwtTokenProvider.generateToken(authentication);
    }
}