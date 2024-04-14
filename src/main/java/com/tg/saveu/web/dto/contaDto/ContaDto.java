package com.tg.saveu.web.dto.contaDto;

import com.tg.saveu.entity.Banco;
import com.tg.saveu.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class ContaDto {

    @NotNull
    private Banco banco;
    @NotNull
    private Usuario usuario;
    @NotBlank
    private String name;
    @NotNull
    private Float balance;
    private Float ceiling;
    @NotBlank
    private String type;

}
