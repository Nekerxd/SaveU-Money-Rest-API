package com.tg.saveu.repository;

import com.tg.saveu.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    @Query("select u.role from Usuario u where u.email like :email")
    Usuario.Role findRoleByEmail(String email);
}
