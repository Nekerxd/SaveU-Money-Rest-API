package com.tg.saveu.service;

import com.tg.saveu.entity.Banco;
import com.tg.saveu.exception.EntityNotFoundException;
import com.tg.saveu.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BancoService {

    private final BancoRepository bancoRepository;

//    @Value("${api.url}")
    private final String apiUrl = "https://brasilapi.com.br/api/banks/v1";

    public List<Banco> atualizarBancos() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Banco[]> response = restTemplate.getForEntity(apiUrl, Banco[].class);
        Banco[] bancosArray = response.getBody();

        List<Banco> bancos = Arrays.stream(bancosArray)
                .filter(banco -> banco.getName() != null)
                .map(banco -> {
                    Banco b = new Banco();
                    b.setName(banco.getName());
                    b.setFullName(banco.getFullName());
                    return b;
                })
                .collect(Collectors.toList());

        for (Banco banco : bancos) {
            if (!bancoRepository.existsByName(banco.getName())) {
                bancoRepository.save(banco);
            }
        }

        return bancoRepository.findAll();
    }


    public List<Banco> obterBancos() {
        return bancoRepository.findAll();
    }

    @Transactional
    public void salvar(List<Banco> bancos) {
        bancoRepository.saveAll(bancos);
    }

    @Transactional(readOnly = true)
    public Banco buscarPorId(Long id) {
        return bancoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Banco id = %s não encontrado", id))
        );
    }

    @Transactional(readOnly = true)
    public List<Banco> buscarPorNome(String name) {
        return bancoRepository.findByNameContainingIgnoreCase(name);
    }

}
