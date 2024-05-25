package com.tg.saveu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter  @Setter
@NoArgsConstructor
@Entity
@Table(name = "movimentacoes")
public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private Float value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    @Column(name = "counterparty")
    private String counterparty;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Categoria category;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public enum Type {
        TYPE_DESPESA, TYPE_RECEITA
    }
    public enum Status {
        STATUS_DESPESA_PAGO, STATUS_DESPESA_APAGAR, STATUS_DESPESA_ATRASADO,
        STATUS_RECEITA_RECEBIDO, STATUS_RECEITA_ARECEBER, STATUS_RECEITA_ATRASADO
    }

    public enum Categoria {
        // Categorias de Despesas
        CATEGORY_DESPESA_ALIMENTACAO, CATEGORY_DESPESA_LAZER, CATEGORY_DESPESA_MORADIA,
        CATEGORY_DESPESA_TRANSPORTE, CATEGORY_DESPESA_SAUDE, CATEGORY_DESPESA_EDUCACAO,
        CATEGORY_DESPESA_VESTUARIO, CATEGORY_DESPESA_SERVICOS, CATEGORY_DESPESA_IMPREVISTOS,
        CATEGORY_DESPESA_SEGUROS, CATEGORY_DESPESA_TAXAS, CATEGORY_DESPESA_EMPRESTIMOS,
        CATEGORY_DESPESA_DIVERSOS, CATEGORY_DESPESA_VIAGEM, CATEGORY_DESPESA_INVESTIMENTOS,
        CATEGORY_DESPESA_DOACOES, CATEGORY_DESPESA_UTILIDADES, CATEGORY_DESPESA_ASSINATURAS,
        CATEGORY_DESPESA_HIGIENE, CATEGORY_DESPESA_PETS, CATEGORY_DESPESA_FERRAMENTAS,
        CATEGORY_DESPESA_OUTRAS_DESPESAS,

        // Categorias de Receitas
        CATEGORY_RECEITA_SALARIO, CATEGORY_RECEITA_FREELANCER, CATEGORY_RECEITA_INVESTIMENTOS,
        CATEGORY_RECEITA_ALUGUEL, CATEGORY_RECEITA_PREMIOS, CATEGORY_RECEITA_PRESENTES,
        CATEGORY_RECEITA_PENSOES, CATEGORY_RECEITA_DIVIDENDOS, CATEGORY_RECEITA_JURUS,
        CATEGORY_RECEITA_VENDA, CATEGORY_RECEITA_REEMBOLSO, CATEGORY_RECEITA_OUTRAS_RECEITAS
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimentacao that = (Movimentacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", conta=" + conta +
                ", counterparty='" + counterparty + '\'' +
                ", category=" + category +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
