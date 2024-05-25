package com.tg.saveu.web.controller;

import com.tg.saveu.entity.Movimentacao;
import com.tg.saveu.service.MovimentacaoService;
import com.tg.saveu.web.dto.contaDto.ContaDto;
import com.tg.saveu.web.dto.movimentacaoDto.MovimentacaoDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<MovimentacaoDto> create(@Valid @RequestBody MovimentacaoDto movimentacaoDto) {
        Movimentacao movimentacao = new ModelMapper().map(movimentacaoDto, Movimentacao.class);
        movimentacaoService.salvar(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> getById(@PathVariable Long id) {
        Movimentacao movimentacao = movimentacaoService.buscarPorId(id);
        return ResponseEntity.ok(movimentacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimentacao(@PathVariable Long id) {
        movimentacaoService.deletarMovimentacao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> listAll() {
        List<Movimentacao> movimentacoes = movimentacaoService.buscarTodas();
        return ResponseEntity.ok(movimentacoes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimentacaoDto> updateMovimentacao(@PathVariable Long id, @Valid @RequestBody MovimentacaoDto movimentacaoDto) {
        Movimentacao movimentacao = new ModelMapper().map(movimentacaoDto, Movimentacao.class);
        movimentacaoService.atualizarMovimentacao(id, movimentacao);
        return ResponseEntity.noContent().build();
    }
}