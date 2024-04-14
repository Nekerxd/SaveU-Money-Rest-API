package com.tg.saveu.web.controller;

import com.tg.saveu.entity.Conta;
import com.tg.saveu.service.ContaService;
import com.tg.saveu.web.dto.contaDto.ContaDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/contas")
public class ContaController {

    private final ContaService contaService;

    @PostMapping
    public ResponseEntity<ContaDto> create(@Valid @RequestBody ContaDto contaDto) {
        contaService.salvar(new ModelMapper().map(contaDto, Conta.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(contaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getById(@PathVariable Long id) {
        Conta conta = contaService.buscarPorId(id);
        return ResponseEntity.ok(conta);
    }

}
