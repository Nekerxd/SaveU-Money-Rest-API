package com.tg.saveu.service;

import com.tg.saveu.entity.CategoryEnum;
import com.tg.saveu.entity.Conta;
import com.tg.saveu.entity.Meta;
import com.tg.saveu.entity.Movimentacao;
import com.tg.saveu.exception.EntityNotFoundException;
import com.tg.saveu.repository.MetaRepository;
import com.tg.saveu.web.dto.metadto.MetaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

    @Transactional(readOnly = true)
    public List<Meta> buscarTodas() {
        return metaRepository.findAll();
    }

    @Transactional
    public boolean verificarUsuario(Long id, Long idUsuario) {
        return !buscarPorId(id).getUsuario().getId().equals(idUsuario);
    }

    @Transactional
    public Meta editarMeta(Long id, Meta meta) {
        Meta metaAtual = metaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Meta id = %s não encontrada", id)));

        metaAtual.setCategory(meta.getCategory());
        metaAtual.setUsuario(meta.getUsuario());
        metaAtual.setGoal(meta.getGoal());
        metaAtual.setDescription(meta.getDescription());
        metaAtual.setRole(meta.getRole());
        metaAtual.setEndDate(meta.getEndDate());
        metaAtual.setStartDate(meta.getStartDate());
        metaAtual.setTitle(meta.getTitle());
        metaAtual.setCategory(meta.getCategory());

        return metaRepository.save(metaAtual);
    }

    @Transactional
    public void deletarMeta(Long id, Long idUsuario) {
        if (verificarUsuario(id, idUsuario)) {
            throw new RuntimeException("Falha na exclusão da meta.");
        }
        metaRepository.delete(buscarPorId(id));
    }
}
