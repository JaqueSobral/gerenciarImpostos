package com.zup.gerenciarImpostos.repositories;
import com.zup.gerenciarImpostos.dtos.request.LoginRequest;
import com.zup.gerenciarImpostos.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByUsername(String username);

    LoginRequest existsByUsername(String username);
}