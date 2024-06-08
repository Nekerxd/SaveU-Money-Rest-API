package com.tg.saveu.web.controller;

import com.tg.saveu.entity.Usuario;
import com.tg.saveu.service.UsuarioService;
import com.tg.saveu.web.dto.mapper.UsuarioMapper;
import com.tg.saveu.web.dto.usuariodto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioCreateDto createDto) {
        Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable long id) {
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @PatchMapping("/senha/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto dto) {
        Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/nome/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Long id, @Valid @RequestBody UsuarioNomeDto dto) {
        Usuario user = usuarioService.editarNome(id, dto.getNovoNome(), dto.getSenha());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/email/{id}")
    public ResponseEntity<Void> updateEmail(@PathVariable Long id, @Valid @RequestBody UsuarioEmailDto dto) {
        Usuario user = usuarioService.editarEmail(id, dto.getNovoEmail(), dto.getConfirmaEmail(), dto.getSenha());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> getAll() {
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(UsuarioMapper.toListDto(users));
    }
}
