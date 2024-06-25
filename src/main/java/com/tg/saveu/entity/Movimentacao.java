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
    private CategoryEnum category;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public enum Type {
        TYPE_DESPESA("Despesa"),
        TYPE_RECEITA("Receita");

        private final String label;
        private Type(String label) {
            this.label = label;
        }

        @JsonValue
        public String getLabel() {
            return label;
        }
    }
    public enum Status {
        STATUS_DESPESA_PAGO("Pago"),
        STATUS_DESPESA_APAGAR("A pagar"),
        STATUS_ATRASADO("Atrasado"),
        STATUS_RECEITA_RECEBIDO("Recebido"),
        STATUS_RECEITA_ARECEBER("A receber");

        private final String label;
        private Status(String label) {
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
