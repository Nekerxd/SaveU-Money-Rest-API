package com.tg.saveu.web.controller;

import com.tg.saveu.entity.Categoria;
import com.tg.saveu.entity.Conta;
import com.tg.saveu.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria) {
        Categoria cat = categoriaService.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(cat);
    }

    @GetMapping()
    public ResponseEntity<List<Categoria>> listById(@RequestParam(name = "id") Long id) {
        List<Categoria> categorias = categoriaService.listar(id);
        return ResponseEntity.ok(categorias);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCategoria(@RequestParam(name = "id", required = true) Long id,
                                           @RequestParam(name = "idUsuario", required = true) Long idUsuario) {
        categoriaService.deletarCategoria(id, idUsuario);
        return  ResponseEntity.noContent().build();
    }
}
