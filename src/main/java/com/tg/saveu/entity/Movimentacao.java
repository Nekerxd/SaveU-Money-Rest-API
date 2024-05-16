package com.tg.saveu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

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
    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;
    @Column(name = "counterparty")
    private String counterparty;

    @Column(name = "category")
    private Categoria category;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
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

}
