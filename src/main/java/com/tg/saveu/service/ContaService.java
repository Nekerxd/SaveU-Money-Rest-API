package com.tg.saveu.service;

import com.tg.saveu.entity.Banco;
import com.tg.saveu.entity.Conta;
import com.tg.saveu.exception.EntityNotFoundException;
import com.tg.saveu.repository.BancoRepository;
import com.tg.saveu.repository.ContaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final BancoService bancoService;

    @Transactional
    public Conta salvar(Conta conta) { return contaRepository.save(conta);}

    @Transactional(readOnly = true)
    public Conta buscarPorId(Long id) {
        System.out.println("Service Buscar ID");
        return contaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Conta id = %s não encontrado", id))
        );
    }

    @Transactional
    public boolean verificarUsuario(Long id, Long idUsuario) {
        System.out.println("Service Verificar Usuario");
        return !buscarPorId(id).getUsuario().getId().equals(idUsuario);
    }

    @Transactional
    public Conta editarConta(Long id, Long idUsuario, String name, Float balance, Float ceiling, String type, Long idBanco) {
        if (verificarUsuario(id, idUsuario)) {
            throw new RuntimeException("Falha ao alterar conta.");
        }

        Conta conta = buscarPorId(id);
        conta.setName(name);
        conta.setBalance(balance);
        conta.setCeiling(ceiling);
        conta.setType(Conta.Type.valueOf(type));
        conta.setBanco(bancoService.buscarPorId(idBanco));

        return conta;
    }

    @Transactional
    public void deletarConta(Long id, Long idUsuario) {
        System.out.println("Service Deletar Conta");
        if (verificarUsuario(id, idUsuario)) {
            throw new RuntimeException("Falha na exclusão da conta.");
        }
        contaRepository.delete(buscarPorId(id));
    }

}
