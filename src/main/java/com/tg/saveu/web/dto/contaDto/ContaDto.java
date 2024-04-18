package com.tg.saveu.web.dto.contaDto;

import com.tg.saveu.entity.Banco;
import com.tg.saveu.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContaDto {

    @NotBlank
    @Size(max = 30)
    private String name;
    @NotNull
    private Float balance;
    @NotNull
    private Float ceiling;
    @NotBlank
    private String type;
    @NotNull
    private Usuario usuario;
    @NotNull
    private Banco banco;
}
