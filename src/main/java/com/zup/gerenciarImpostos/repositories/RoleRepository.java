package com.zup.gerenciarImpostos.repositories;

import com.zup.gerenciarImpostos.dtos.RoleEnum;
import com.zup.gerenciarImpostos.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByName(String name);
}