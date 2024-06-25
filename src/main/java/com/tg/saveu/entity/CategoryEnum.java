package com.tg.saveu.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryEnum {


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

    private String label;
    CategoryEnum(String label) {
        this.label = label;
    }
    @JsonValue
    public String getLabel() {
        return label;
    }
}
