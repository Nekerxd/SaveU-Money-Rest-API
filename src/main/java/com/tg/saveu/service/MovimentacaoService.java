package com.tg.saveu.service;

import com.tg.saveu.entity.Conta;
import com.tg.saveu.entity.Movimentacao;
import com.tg.saveu.exception.EntityNotFoundException;
import com.tg.saveu.repository.ContaRepository;
import com.tg.saveu.repository.MovimentacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final ContaRepository contaRepository;

    @Transactional
    public Movimentacao salvar(Movimentacao movimentacao) {
        Conta conta = contaRepository.findById(movimentacao.getConta().getId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Conta id = %s não encontrada", movimentacao.getConta().getId())));
        movimentacao.setConta(conta);
        return movimentacaoRepository.save(movimentacao);
    }

    @Transactional(readOnly = true)
    public Movimentacao buscarPorId(Long id) {
        return movimentacaoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Movimentação id = %s não encontrada", id)));
    }

    @Transactional
    public void deletarMovimentacao(Long id) {
        movimentacaoRepository.delete(buscarPorId(id));
    }

    @Transactional(readOnly = true)
    public List<Movimentacao> buscarTodas() {
        return movimentacaoRepository.findAll();
    }

    @Transactional
    public Movimentacao atualizarMovimentacao(Long id, Movimentacao movimentacao) {
        Movimentacao movimentacaoAtual = movimentacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Movimentação id = %s não encontrada", id)));

        Conta conta = contaRepository.findById(movimentacaoAtual.getConta().getId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Conta id = %s não encontrada", movimentacaoAtual.getConta().getId())));

        movimentacaoAtual.setConta(conta);
        movimentacaoAtual.setDate(movimentacao.getDate());
        movimentacaoAtual.setDescription(movimentacao.getDescription());
        movimentacaoAtual.setValue(movimentacao.getValue());
        movimentacaoAtual.setCounterparty(movimentacao.getCounterparty());
        movimentacaoAtual.setCategory(movimentacao.getCategory());
        movimentacaoAtual.setType(movimentacao.getType());
        movimentacaoAtual.setStatus(movimentacao.getStatus());

        return movimentacaoRepository.save(movimentacaoAtual);
    }
}
