package com.tg.saveu.web.controller;

import com.tg.saveu.entity.Meta;
import com.tg.saveu.entity.Movimentacao;
import com.tg.saveu.service.MetaService;
import com.tg.saveu.web.dto.mapper.MetaMapper;
import com.tg.saveu.web.dto.metadto.*;
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
@RequestMapping("api/v1/metas")
public class MetaController {

    private final MetaService metaService;

    @PostMapping
    public ResponseEntity<MetaDto> create(@Valid @RequestBody MetaDto createDto) {
        Meta meta = new ModelMapper().map(createDto, Meta.class);
        metaService.salvar(meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meta> getById(@PathVariable Long id) {
        Meta meta = metaService.buscarPorId(id);
        return ResponseEntity.ok(meta);
    }

    @GetMapping
    public ResponseEntity<List<Meta>> listAll() {
        List<Meta> metas = metaService.buscarTodas();
        return ResponseEntity.ok(metas);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMeta(@PathVariable Long id, @Valid @RequestBody MetaDto metaDto) {
        Meta meta = new ModelMapper().map(metaDto, Meta.class);
        metaService.editarMeta(id, meta);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeta(@PathVariable Long id, @RequestParam Long idUsuario) {
        metaService.deletarMeta(id, idUsuario);
        return  ResponseEntity.noContent().build();
    }

}
