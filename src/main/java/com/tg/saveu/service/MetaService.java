package com.tg.saveu.service;

import com.tg.saveu.entity.Meta;
import com.tg.saveu.exception.EntityNotFoundException;
import com.tg.saveu.repository.MetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class MetaService {

    private final MetaRepository metaRepository;

    @Transactional
    public Meta salvar(Meta meta) {
        return metaRepository.save(meta);
    }

    @Transactional(readOnly = true)
    public Meta buscarPorId(Long id) {
        return metaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Meta id = %s não encontrado", id))
        );
    }

    @Transactional
    public boolean verificarUsuario(Long id, Long idUsuario) {
        return !buscarPorId(id).getUsuario().getId().equals(idUsuario);
    }

    @Transactional
    public Meta editarMeta(Long id, Long idUsuario, String descricao, Float objetivo, LocalDate prazo, String role) {
        if (verificarUsuario(id, idUsuario)) {
            throw new RuntimeException("Falha ao alterar meta.");
        }

        Meta meta = buscarPorId(id);
        meta.setDescription(descricao);
        meta.setGoal(objetivo);
        meta.setDueDate(prazo);
        meta.setRole(Meta.Role.valueOf(role));

        return meta;
    }

    @Transactional
    public void deletarMeta(Long id, Long idUsuario) {
        if (verificarUsuario(id, idUsuario)) {
            throw new RuntimeException("Falha na exclusão da meta.");
        }
        metaRepository.delete(buscarPorId(id));
    }
}
