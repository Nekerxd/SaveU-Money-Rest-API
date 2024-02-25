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

import java.util.List;

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

    @PatchMapping("/descricao/{id}")
    public ResponseEntity<Void> updateDescription(@PathVariable Long id, @Valid @RequestBody MetaDescricaoDto dto) {
        Meta meta = metaService.editarDescricao(id, dto.getIdUsuario(), dto.getNovaDescricao());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/objetivo/{id}")
    public ResponseEntity<Void> updateGoal(@PathVariable Long id, @Valid @RequestBody MetaObjetivoDto dto) {
        Meta meta = metaService.editarObjetivo(id, dto.getIdUsuario(), dto.getNovoObjetivo());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/prazo/{id}")
    public ResponseEntity<Void> updateDueDate(@PathVariable Long id, @Valid @RequestBody MetaPrazoDto dto) {
        Meta meta = metaService.editarPrazo(id, dto.getIdUsuario(), dto.getNovoPrazo());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<MetaResponseDto>> getAll(@PathVariable Long idUsuario) {
        List<Meta> metas = metaService.buscarTodos(idUsuario);
        return ResponseEntity.ok(MetaMapper.toListDto(metas));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMeta(@PathVariable Long id, @Valid @RequestBody MetaUsuarioDto dto) {
        metaService.deletarMeta(id, dto.getIdUsuario());
        return  ResponseEntity.noContent().build();
    }
}
