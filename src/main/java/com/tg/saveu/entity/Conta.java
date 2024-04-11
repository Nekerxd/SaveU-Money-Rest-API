package com.tg.saveu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contas")
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "balance", nullable = false)
    private Float balance;
    @Column(name = "limit", nullable = false)
    private Float limit;
    @Column(name = "type", nullable = false, length = 25)
    private Type type;

    public enum Type {
        TYPE_CORRENTE, TYPE_CREDITO, TYPE_APLICACAO, TYPE_REFEICAO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(id, conta.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id);}

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                '}';
    }
}