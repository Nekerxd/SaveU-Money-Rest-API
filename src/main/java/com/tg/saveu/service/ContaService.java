package com.tg.saveu.service;

import com.tg.saveu.entity.Conta;
import com.tg.saveu.exception.EntityNotFoundException;
import com.tg.saveu.repository.ContaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;

    @Transactional
    public Conta salvar(Conta conta) { return contaRepository.save(conta);}

    @Transactional(readOnly = true)
    public Conta buscarPorId(Long id) {
        return contaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Conta id = %s não encontrado", id))
        );
    }

}
