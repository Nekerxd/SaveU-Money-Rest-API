package com.tg.saveu.repository;

import com.tg.saveu.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BancoRepository extends JpaRepository<Banco, Long> {
    List<Banco> findByNameContainingIgnoreCase(String name);
    boolean existsByName(String name);
}
