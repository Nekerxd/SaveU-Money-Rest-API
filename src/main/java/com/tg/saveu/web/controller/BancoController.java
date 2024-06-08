package com.tg.saveu.web.controller;

import com.tg.saveu.entity.Banco;
import com.tg.saveu.service.BancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/bancos")
public class BancoController {

    private final BancoService bancoService;


    @GetMapping
    public ResponseEntity<List<Banco>> getAll() {
        List<Banco> banco = bancoService.obterBancos();
        return ResponseEntity.ok(banco);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Banco> getById(@PathVariable Long id) {
        Banco banco = bancoService.buscarPorId(id);
        return ResponseEntity.ok(banco);
    }

    @GetMapping("/nome/{name}")
    public List<Banco> getByName(@PathVariable String name) {
        return bancoService.buscarPorNome(name);
    }

}
