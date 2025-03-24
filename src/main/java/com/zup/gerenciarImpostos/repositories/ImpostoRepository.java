package com.zup.gerenciarImpostos.repositories;

import com.zup.gerenciarImpostos.entities.ImpostoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpostoRepository extends JpaRepository<ImpostoEntity, Long> {
}
