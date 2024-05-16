package com.tg.saveu.service;

import com.tg.saveu.entity.Categoria;
import com.tg.saveu.exception.EntityNotFoundException;
import com.tg.saveu.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional(readOnly = true)
    public List<Categoria> listar(Long id) {
        return categoriaRepository.findByUsuarioId(id);
    }

    @Transactional
    public boolean verificarUsuario(Long id, Long idUsuario) {
        return !buscarPorId(id).getUsuarioId().equals(idUsuario);
    }

    @Transactional
    public void deletarCategoria(Long id, Long idUsuario) {
        if (verificarUsuario(id, idUsuario)) {
            throw new RuntimeException("Falha na exclusão da categoria.");
        }
        categoriaRepository.delete(buscarPorId(id));
    }

    @Transactional(readOnly = true)
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Categoria id = %s não encontrado", id))
        );
    }
}
