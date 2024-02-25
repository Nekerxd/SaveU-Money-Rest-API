package com.tg.saveu.repository;

import com.tg.saveu.entity.Meta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetaRepository extends JpaRepository<Meta, Long> {
    List<Meta> findByIdUsuario(Long idUsuario);
}
