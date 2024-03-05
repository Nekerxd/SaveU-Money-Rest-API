package com.tg.saveu.web.controller;

import com.tg.saveu.entity.Meta;
import com.tg.saveu.service.MetaService;
import com.tg.saveu.web.dto.mapper.MetaMapper;
import com.tg.saveu.web.dto.metadto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/metas")
public class MetaController {

    private final MetaService metaService;

    @PostMapping
    public ResponseEntity<MetaResponseDto> create(@Valid @RequestBody MetaCreateDto createDto) {
        Meta meta = metaService.salvar(MetaMapper.toMeta(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(MetaMapper.toDto(meta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetaResponseDto> getById(@PathVariable Long id) {
        Meta meta = metaService.buscarPorId(id);
        return ResponseEntity.ok(MetaMapper.toDto(meta));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMeta(@PathVariable Long id, @Valid @RequestBody MetaUpdateDto dto) {
        metaService.editarMeta(id, dto.getUsuario().getId(), dto.getNovaDescricao(), dto.getNovoObjetivo(), dto.getNovoPrazo(),  dto.getRole());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMeta(@PathVariable Long id, @Valid @RequestBody MetaUsuarioDto dto) {
        metaService.deletarMeta(id, dto.getUsuario().getId());
        return  ResponseEntity.noContent().build();
    }
}
