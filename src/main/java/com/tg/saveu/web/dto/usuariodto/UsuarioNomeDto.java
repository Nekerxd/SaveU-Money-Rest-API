package com.tg.saveu.web.dto.usuariodto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioNomeDto {

    @NotBlank
    @Size(max = 100)
    private String novoNome;
    @NotBlank
    @Size(min = 8, max = 32)
    private String senha;
}
