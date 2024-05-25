package com.tg.saveu.web.dto.movimentacaoDto;

import com.tg.saveu.entity.Conta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovimentacaoDto {

    @NotNull
    private Date date;

    @NotBlank
    @Size(max = 150)
    private String description;

    @NotNull
    private Float value;

    @NotNull
    private Conta conta;

    private String counterparty;

    private String category;

    @NotBlank
    private String type;

    @NotBlank
    private String status;
}