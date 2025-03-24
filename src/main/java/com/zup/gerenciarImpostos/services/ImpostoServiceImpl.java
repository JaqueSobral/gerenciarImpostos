package com.zup.gerenciarImpostos.services;

import com.zup.gerenciarImpostos.dtos.CalculoImpostoResponse;
import com.zup.gerenciarImpostos.dtos.TipoImpostoResponse;
import com.zup.gerenciarImpostos.dtos.request.TipoImpostoRequest;
import com.zup.gerenciarImpostos.entities.ImpostoEntity;
import com.zup.gerenciarImpostos.repositories.ImpostoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpostoServiceImpl implements ImpostoService {

        private final ImpostoRepository impostoRepository;

        public ImpostoServiceImpl(ImpostoRepository impostoRepository) {
            this.impostoRepository = impostoRepository;
        }

        @Override
        public List<ImpostoEntity> listarTodos() {
            return impostoRepository.findAll();
        }

        @Override
        public ResponseEntity<TipoImpostoResponse> cadastrarImposto(TipoImpostoRequest tipoImpostoRequest) {
            if (tipoImpostoRequest == null || tipoImpostoRequest.getName() == null || tipoImpostoRequest.getDescricao() == null) {
                throw new IllegalArgumentException("Os campos nome e descrição são obrigatórios.");
            }
            ImpostoEntity impostoEntity = ImpostoEntity.builder()
                    .name(tipoImpostoRequest.getName())
                    .descricao(tipoImpostoRequest.getDescricao())
                    .aliquota(tipoImpostoRequest.getAliquota())
                    .build();
            ImpostoEntity salvarImposto = impostoRepository.save(impostoEntity);
            TipoImpostoResponse tipoImpostoResponse = TipoImpostoResponse.builder()
                    .id(salvarImposto.getId())
                    .name(salvarImposto.getName())
                    .descricao(salvarImposto.getDescricao())
                    .aliquota(salvarImposto.getAliquota())
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoImpostoResponse);
        }


        @Override
        public CalculoImpostoResponse calcularImposto(Long tipoImpostoId, double valorBase) {

        if (valorBase <= 0) {
            throw new IllegalArgumentException("O valor base deve ser maior que zero.");
        }
        ImpostoEntity impostoEntity = impostoRepository.findById(tipoImpostoId)
                .orElseThrow(() -> new RuntimeException("Tipo de imposto não encontrado"));
        double aliquota = impostoEntity.getAliquota();
        double valorImposto = valorBase * (aliquota / 100);
        return CalculoImpostoResponse.builder()
                .tipoImposto(impostoEntity.getName()) // Nome do imposto
                .valorBase(valorBase)
                .aliquota(aliquota)
                .valorImposto(valorImposto)
                .build();
        }

        @Override
        public TipoImpostoResponse buscarPorId(Long id) {
            ImpostoEntity impostoEntity = impostoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Imposto não encontrado"));
            return new TipoImpostoResponse(
                    impostoEntity.getId(),
                    impostoEntity.getName(),
                    impostoEntity.getDescricao(),
                    impostoEntity.getAliquota()
            );
        }

        @Override
        public void excluirImposto(Long id) {
            if (!impostoRepository.existsById(id)) {
                throw new RuntimeException("Imposto não encontrado");
            }
            impostoRepository.deleteById(id);
        }
    }