package com.zup.gerenciarImpostos.controllers;

import com.zup.gerenciarImpostos.dtos.CalculoImpostoResponse;
import com.zup.gerenciarImpostos.dtos.TipoImpostoResponse;
import com.zup.gerenciarImpostos.dtos.request.CalculoImpostoRequest;
import com.zup.gerenciarImpostos.dtos.request.TipoImpostoRequest;
import com.zup.gerenciarImpostos.entities.ImpostoEntity;
import com.zup.gerenciarImpostos.services.ImpostoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tipos")
public class TipoImpostoController {

    @Autowired
    private ImpostoService impostoService;

    @GetMapping
    public List<ImpostoEntity> listarTipos() {
        return impostoService.listarTodos();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TipoImpostoResponse> cadastrarTipo(@RequestBody TipoImpostoRequest tipoImpostoRequest) {
        TipoImpostoResponse novoTipoResponse = impostoService.cadastrarImposto(tipoImpostoRequest).getBody();
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTipoResponse);
    }

    @PostMapping("/calculo")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> calcularImposto(@Valid @RequestBody CalculoImpostoRequest request) {
        if (request.getValorBase() == null) {
            return ResponseEntity.badRequest().body("O campo 'valorBase' não pode ser nulo.");
        }

        CalculoImpostoResponse response = impostoService
                .calcularImposto(request.getTipoImpostoId(), request.getValorBase());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoImpostoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(impostoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTipo(@PathVariable Long id) {
        impostoService.excluirImposto(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
}