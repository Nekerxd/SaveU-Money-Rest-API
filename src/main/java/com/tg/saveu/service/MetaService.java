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
    public Meta editarDescricao(Long id, Long idUsuario, String novaDescricao) {
        if (verificarUsuario(id, idUsuario)) {
            throw new RuntimeException("Falha ao alterar descrição.");
        }
        Meta meta = buscarPorId(id);

        meta.setDescription(novaDescricao);
        return meta;
    }

    @Transactional
    public Meta editarObjetivo(Long id, Long idUsuario, Float novoObjetivo) {
        if (verificarUsuario(id, idUsuario)) {
            throw new RuntimeException("Falha ao alterar objetivo.");
        }
        Meta meta = buscarPorId(id);

        meta.setGoal(novoObjetivo);
        return meta;
    }

    @Transactional
    public Meta editarPrazo(Long id, Long idUsuario, LocalDate novoPrazo) {
        if (verificarUsuario(id, idUsuario)) {
            throw new RuntimeException("Falha ao alterar prazo.");
        }
        Meta meta = buscarPorId(id);

        meta.setDueDate(novoPrazo);
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
