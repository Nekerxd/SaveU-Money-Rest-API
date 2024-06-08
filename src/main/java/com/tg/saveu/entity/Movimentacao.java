package com.tg.saveu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
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

    @JsonIgnore
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
        STATUS_DESPESA_PAGO, STATUS_DESPESA_APAGAR, STATUS_ATRASADO,
        STATUS_RECEITA_RECEBIDO, STATUS_RECEITA_ARECEBER,
    }

    public enum Categoria {
        // Categorias de Despesas
        CATEGORY_DESPESA_ALIMENTACAO("Alimentação"),
        CATEGORY_DESPESA_LAZER("Lazer"),
        CATEGORY_DESPESA_MORADIA("Moradia"),
        CATEGORY_DESPESA_TRANSPORTE("Transporte"),
        CATEGORY_DESPESA_SAUDE("Saúde"),
        CATEGORY_DESPESA_EDUCACAO("Educação"),
        CATEGORY_DESPESA_VESTUARIO("Vestuário"),
        CATEGORY_DESPESA_SERVICOS("Serviços"),
        CATEGORY_DESPESA_IMPREVISTOS("Imprevistos"),
        CATEGORY_DESPESA_SEGUROS("Seguros"),
        CATEGORY_DESPESA_TAXAS("Taxas"),
        CATEGORY_DESPESA_EMPRESTIMOS("Empréstimos"),
        CATEGORY_DESPESA_DIVERSOS("Diversos"),
        CATEGORY_DESPESA_VIAGEM("Viagem"),
        CATEGORY_DESPESA_INVESTIMENTOS("Investimentos"),
        CATEGORY_DESPESA_DOACOES("Doações"),
        CATEGORY_DESPESA_UTILIDADES("Utilidades"),
        CATEGORY_DESPESA_ASSINATURAS("Assinaturas"),
        CATEGORY_DESPESA_HIGIENE("Higiene"),
        CATEGORY_DESPESA_PETS("Pets"),
        CATEGORY_DESPESA_FERRAMENTAS("Ferramentas"),
        CATEGORY_DESPESA_OUTRAS_DESPESAS("Outras Despesas"),

        // Categorias de Receitas
        CATEGORY_RECEITA_SALARIO("Salário"),
        CATEGORY_RECEITA_FREELANCER("Freelancer"),
        CATEGORY_RECEITA_INVESTIMENTOS("Investimentos"),
        CATEGORY_RECEITA_ALUGUEL("Aluguel"),
        CATEGORY_RECEITA_PREMIOS("Prêmios"),
        CATEGORY_RECEITA_PRESENTES("Presentes"),
        CATEGORY_RECEITA_PENSOES("Pensões"),
        CATEGORY_RECEITA_DIVIDENDOS("Dividendos"),
        CATEGORY_RECEITA_JURUS("Juros"),
        CATEGORY_RECEITA_VENDA("Venda"),
        CATEGORY_RECEITA_REEMBOLSO("Reembolso"),
        CATEGORY_RECEITA_OUTRAS_RECEITAS("Outras Receitas");

        private final String label;
        private Categoria(String label) {
            this.label = label;
        }

        @JsonValue
        public String getLabel() {
            return label;
        }
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
