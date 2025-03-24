package com.zup.gerenciarImpostos.services;

import com.zup.gerenciarImpostos.dtos.CalculoImpostoResponse;
import com.zup.gerenciarImpostos.dtos.TipoImpostoResponse;
import com.zup.gerenciarImpostos.dtos.request.TipoImpostoRequest;
import com.zup.gerenciarImpostos.entities.ImpostoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ImpostoService {
    List<ImpostoEntity> listarTodos();
    ResponseEntity<TipoImpostoResponse> cadastrarImposto(TipoImpostoRequest tipoImpostoRequest);
    CalculoImpostoResponse calcularImposto(Long tipoImpostoId, double valorBase);
    TipoImpostoResponse buscarPorId(Long id);
    void excluirImposto(Long id);
}