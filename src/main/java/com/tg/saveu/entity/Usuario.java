package com.tg.saveu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "password", nullable = false, length = 200)
    private String password;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 25)
    private Role role = Role.ROLE_CLIENTE;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "usuario")
    private Collection<Meta> metas;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private Collection<Conta> contas;

    public enum Role {
        ROLE_ADMIN, ROLE_CLIENTE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }
}
