package com.tg.saveu.web.dto.movimentacaoDto;

import com.tg.saveu.entity.Conta;
import jdk.jfr.Category;
import lombok.*;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MovimentacaoResponseDto {

    private Date date;
    private String description;
    private Float value;
    private Conta conta;
    private String counterparty;
    private String category;
    private String type;
    private String status;
}
